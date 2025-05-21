package IteratorPattern;

import java.util.ArrayList;
import java.util.List;

public class BookCollectionV1 {
    public List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> getBooks() {
        return books;
    }
}