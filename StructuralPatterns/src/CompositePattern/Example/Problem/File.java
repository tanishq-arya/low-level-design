package CompositePattern.Example.Problem;

import CompositePattern.Example.Solution.FileSystemComponent;

public class File implements FileSystemComponent {
    private final String name;

    public File(String name) {
        this.name = name;
    }

    public void showDetails() {
        System.out.println("File: " + name);
    }
}