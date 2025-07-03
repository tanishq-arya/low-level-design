package LibraryManagementSystem;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

// Facade
public class Library {
    private final Map<String, Book> books = new ConcurrentHashMap<>();
    private final Map<String, Member> members = new ConcurrentHashMap<>();
    private final Map<String, Loan> loans = new ConcurrentHashMap<>();

    private static final int MAX_BORROW = 5;
    private static final int LOAN_PERIOD_DAYS = 14;
    private static final double PENALTY_PER_DAY = 4.5;

    // Add a new book to catalog
    public synchronized void addBook(Book book) {
        books.put(book.getIsbn(), book);
    }

    // Remove book from catalog
    public synchronized void removeBook(String isbn) {
        Book book = books.get(isbn);
        if (book == null) {
            System.out.println("Book not found!!");
        }
        if (book.getStatus() != BookStatus.AVAILABLE) {
            System.out.println("Cannot remove: Book is not available");
        }
        books.remove(isbn);
    }

    public synchronized Member registerMember(String name, String contactInfo) {
        Member member = new Member(name, contactInfo);
        members.put(member.getId(), member);
        return member;
    }

    // borrow book
    public Loan borrowBook(String memberId, String isbn) {
        Member member = synchronizedGetMember(memberId); // members.get(memberId);
        Book book = synchronizedGetBook(isbn);

        synchronized (member) {
            if (member.getActiveLoans().size() >= MAX_BORROW) {
                throw new RuntimeException("Member has reached max borrow limit.");
            }

            synchronized (book) {
                if (book.getStatus() != BookStatus.AVAILABLE) {
                    throw new RuntimeException("Book is not available.");
                }

                // Create loan
                LocalDate today = LocalDate.now();
                LocalDate dueDate = today.plusDays(LOAN_PERIOD_DAYS);
                Loan loan = new Loan(book, member, today, dueDate);

                // Update status
                book.setStatus(BookStatus.BORROWED);
                member.addLoan(loan);

                synchronized (loans) {
                    loans.put(loan.getId(), loan);
                }

                return loan;
            }
        }
    }

    // Return a borrowed book
    public void returnBook(String loanId) {
        Loan loan = synchronizedGetLoan(loanId);
        Book book = loan.getBook();
        Member member = loan.getMember();

        synchronized (member) {
            if (loan.isReturned()) {
                throw new RuntimeException("Book already returned");
            }

            // Mark returned
            LocalDate today = LocalDate.now();
            loan.setReturnDate(today);

            // Compute overdue penalty
            long daysLate = ChronoUnit.DAYS.between(loan.getDueDate(), today);
            if (daysLate > 0) {
               double penalty = daysLate * PENALTY_PER_DAY;
               loan.setPenalty(penalty);
                System.out.printf("Loan %s is %d days overdue. Penalty: ₹%.2f%n",
                        loan.getId(), daysLate, penalty);
            }

            // update book and member
            book.setStatus(BookStatus.AVAILABLE);
            member.removeLoan(loan);
        }
    }

    private Book synchronizedGetBook(String isbn) {
        synchronized (books) {
            Book book = books.get(isbn);
            if (book == null) throw new RuntimeException("Book not found");
            return book;
        }
    }

    private Member synchronizedGetMember(String memberId) {
        synchronized (members) {
            Member member = members.get(memberId);
            if (member == null) throw new RuntimeException("Member not found");
            return member;
        }
    }

    private Loan synchronizedGetLoan(String loanId) {
        synchronized (loans) {
            Loan loan = loans.get(loanId);
            if (loan == null) throw new RuntimeException("Loan not found");
            return loan;
        }
    }

    // Search all books whose title contains the given keyword
    public synchronized List<Book> searchByTitle(String keyword) {
        String lower = keyword.toLowerCase();
        return books.values().stream()
                .filter(b -> b.getTitle().toLowerCase().contains(lower))
                .collect(Collectors.toList());
    }

    // Search all books published in given year
    public synchronized List<Book> searchByYear(int year) {
        return books.values().stream()
                .filter(b -> b.getPublicationYear() == year)
                .collect(Collectors.toList());
    }

    // More > searchByAuthor(), searchByIsbn(), searchByStatus()
}