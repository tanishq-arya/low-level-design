package CompositePattern.Example.Solution;

import java.util.ArrayList;
import java.util.List;

public class Folder {
    private final String name;

    // Problem: This code doesn't treat files / folders uniformly
    private final List<File> files = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    public void addFile(File file) {
        this.files.add(file);
    }

    public void showDetails() {
        System.out.println("Folder: " + name);
        for(File file: this.files) {
            file.showDetails();
        }
    }
}