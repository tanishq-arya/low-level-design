package LSP.GoodCode;

public class Main {
    public static void readAnyFile(ReadableFile file) {
        file.read();
    }

    public static void main(String[] args) {
        // Superclass
        ReadableFile readOnlyFile = new ReadableFile();
        readOnlyFile.read();
        // readOnlyFile.write(); // this method is not available -> LSP is not violated

        // Subclass
        WritableFile writableFile = new WritableFile();
        writableFile.read();
        writableFile.write();

        // LSP is followed here
        readAnyFile(readOnlyFile); // parent class object
        readAnyFile(writableFile); // we can replace with child class object
    }
}
