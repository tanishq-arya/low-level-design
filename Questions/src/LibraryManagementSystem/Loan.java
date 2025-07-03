package LibraryManagementSystem;

import java.time.LocalDate;
import java.util.UUID;

public class Loan {
    private final String id;
    private final Book book;
    private final Member member;
    private final LocalDate borrowDate;
    private final LocalDate dueDate;
    private LocalDate returnDate;

    // For late returns
    private double penalty = 0.0;

    public Loan(Book book, Member member, LocalDate borrowDate, LocalDate dueDate) {
        this.id = UUID.randomUUID().toString();
        this.book = book;
        this.member = member;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
    }

    public String getId() {
        return id;
    }

    public Book getBook() {
        return book;
    }

    public Member getMember() {
        return member;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public synchronized LocalDate getReturnDate() {
        return returnDate;
    }

    public synchronized void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    // extra method
    public boolean isReturned() {
        return returnDate != null;
    }

    public synchronized double getPenalty() {
        return penalty;
    }

    protected synchronized void setPenalty(double penalty) {
        this.penalty = penalty;
    }
}