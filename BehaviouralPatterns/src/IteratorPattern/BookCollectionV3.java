package IteratorPattern;

import java.util.*;

public class BookCollectionV3 implements Iterable<Book>{
    private final Set<Book> books = new TreeSet<>();

    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public Iterator<Book> iterator() {
        return books.iterator(); // collection method
    }
}