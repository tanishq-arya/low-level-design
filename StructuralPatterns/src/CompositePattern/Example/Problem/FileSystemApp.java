package CompositePattern.Example.Problem;

import CompositePattern.Example.Solution.FileSystemComponent;

public class FileSystemApp {
    public static void main(String[] args) {
        FileSystemComponent file1 = new File("file1.txt");
        FileSystemComponent file2 = new File("file2.txt");

        Folder folder = new Folder("Documents");
        folder.addComponent(file1);
        folder.addComponent(file2);

        // Subfolder:
        Folder subfolder = new Folder("Subfolder");
        FileSystemComponent file3 = new File("file3.txt");

        subfolder.addComponent(file3);
        folder.addComponent(subfolder);

        // - folder:
        //      - file1
        //      - file2
        //      - subfolder
        //          - file3

        folder.showDetails(); // recursive dfs approach

        // Benefits:
        // 1. Uniformity
        // 2. Scalability
    }
}