package IteratorPattern;

public class ClientV1 {
    public static void main(String[] args) {
        BookCollectionV1 bookCollection = new BookCollectionV1();
        bookCollection.addBook(new Book("C++ Book"));
        bookCollection.addBook(new Book("Java Book"));
        bookCollection.addBook(new Book("Python Book"));

        // Problem ->
        // 1. we have to access the internal structure here
        // 2. if we switch to set -> we cannot use the getBooks.get(i) method
        // 3. This code will break
        for(int i=0; i<bookCollection.getBooks().size(); i++) {
            System.out.println(bookCollection.getBooks().get(i));
        }

        // Solution -> make a generic solution
    }
}