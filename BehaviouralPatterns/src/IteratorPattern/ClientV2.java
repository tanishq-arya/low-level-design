package IteratorPattern;

import java.util.Iterator;

public class ClientV2 {
    public static void main(String[] args) {
        BookCollectionV2 bookCollectionV2 = new BookCollectionV2();
        bookCollectionV2.addBook(new Book("C++ Book"));
        bookCollectionV2.addBook(new Book("Java Book"));
        bookCollectionV2.addBook(new Book("Python Book"));

        // Custom iterator object ->
        // even if internal structure changes we can still use this same code
        Iterator<Book> iterator = bookCollectionV2.createIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}