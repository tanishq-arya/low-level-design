package LSP.BadCode;

public class Main {
    public static void main(String [] args) {
        File file = new ReadOnlyFile();
        file.read(); // works fine
        file.write(); // throws an exception, bad design -> violates LSP
    }
}
