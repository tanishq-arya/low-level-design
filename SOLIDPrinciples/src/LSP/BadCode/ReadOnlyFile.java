package LSP.BadCode;

public class ReadOnlyFile extends File {
    @Override
    public void write() {
        // Why do this ? -> A read-only file cant be written over.
        // Violates LSP -> As this method will throw an exception,
        // if an object of this class substitutes object of its parent class
        throw new UnsupportedOperationException("Can't write a read only file");
    }
}
