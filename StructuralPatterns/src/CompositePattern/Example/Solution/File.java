package CompositePattern.Example.Solution;

public class File {
    private final String name;

    public File(String name) {
        this.name = name;
    }

    public void showDetails() {
        System.out.println("File: " + name);
    }
}