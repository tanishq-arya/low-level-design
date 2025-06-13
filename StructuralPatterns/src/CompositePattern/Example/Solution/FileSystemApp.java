package CompositePattern.Example.Solution;

public class FileSystemApp {
    public static void main(String[] args) {
        File file1 = new File("file1.txt");
        File file2 = new File("file2.txt");

        Folder folder = new Folder("Documents");
        folder.addFile(file1);
        folder.addFile(file2);

        folder.showDetails();

        // Problem: This code doesn't treat files / folders uniformly
    }
}