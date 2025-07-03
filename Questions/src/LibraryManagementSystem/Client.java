package LibraryManagementSystem;

import java.util.List;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        Library library = new Library();

        // Add books
        Book b1 = new Book("ISBN001", "Clean Code", "Robert C. Martin", 2008);
        Book b2 = new Book("ISBN002", "Effective Java", "Joshua Bloch", 2018);
        library.addBook(b1);
        library.addBook(b2);

        // Add more books
        library.addBook(new Book("ISBN003", "Java Concurrency", "Brian Goetz", 2006));
        library.addBook(new Book("ISBN004", "Design Patterns", "Erich Gamma", 1994));

        // Register member
        Member alice = library.registerMember("Alice", "alice@example.com");

        // Search by title
        System.out.println("Search title 'Java':");
        List<Book> javaBooks = library.searchByTitle("Java");
        javaBooks.forEach(b -> System.out.println("  " + b));

        // Search by year
        System.out.println("\nSearch year 2006:");
        List<Book> yearBooks = library.searchByYear(2006);
        yearBooks.forEach(b -> System.out.println("  " + b));

        // Borrow a book
        Loan loan = library.borrowBook(alice.getId(), b1.getIsbn());
        System.out.println("Loan created: " + loan.getId()
                + ", due: " + loan.getDueDate());

        Thread.sleep(1000);

        // Try borrowing same book again (should fail)
        try {
            library.borrowBook(alice.getId(), b1.getIsbn());
        } catch (Exception e) {
            System.out.println("Expected error: " + e.getMessage());
        }

        // Return the book
        library.returnBook(loan.getId());
        System.out.println("Book returned: " + b1.getTitle()
                + ", status: " + b1.getStatus());

        // Borrow again
        Loan loan2 = library.borrowBook(alice.getId(), b1.getIsbn());
        System.out.println("Second loan: " + loan2.getId()
                + ", borrow date: " + loan2.getBorrowDate());

        // Remove book (now available)
        library.returnBook(loan2.getId());
        library.removeBook(b1.getIsbn());
        System.out.println("Book removed from catalog.");

        // History for alice
        for (Loan h : alice.getHistory()) {
            System.out.println("History entry: Loan " + h.getId()
                    + " Book: " + h.getBook().getTitle()
                    + " Returned on: " + h.getReturnDate()
                    + " Penalty: ₹" + h.getPenalty());
        }
    }
}