package LibraryManagementSystem;

public class Book {
    private final String isbn;
    private final String title;
    private final String author;
    private final int publicationYear;
    private BookStatus status;

    public Book(String isbn, String title, String author, int publicationYear) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.status = BookStatus.AVAILABLE;
    }

    public synchronized void setStatus(BookStatus status) {
        this.status = status;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    // synchronized > can be read by multiple users
    public synchronized BookStatus getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return String.format("%s - %s by %s (%d) [%s]",
                isbn, title, author, publicationYear, status);
    }
}