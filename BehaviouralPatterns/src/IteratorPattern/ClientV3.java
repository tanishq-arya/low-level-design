package IteratorPattern;

public class ClientV3 {
    public static void main(String[] args) {
        BookCollectionV3 bookCollectionV3 = new BookCollectionV3();
        bookCollectionV3.addBook(new Book("C++ Book"));
        bookCollectionV3.addBook(new Book("Java Book"));
        bookCollectionV3.addBook(new Book("Python Book"));

        // Using the collections Iterator
        for (Book book : bookCollectionV3) {
            System.out.println(book);
        }
    }
}