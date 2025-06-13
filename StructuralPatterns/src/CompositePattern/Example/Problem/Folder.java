package CompositePattern.Example.Problem;

import CompositePattern.Example.Solution.FileSystemComponent;

import java.util.ArrayList;
import java.util.List;

public class Folder implements FileSystemComponent {
    private final String name;

    // Solution: Use interface
    // This code treats files / folders uniformly
    private final List<FileSystemComponent> components = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    public void addComponent(FileSystemComponent component) {
        this.components.add(component);
    }

    public void showDetails() {
        System.out.println("Folder: " + name);
        for(FileSystemComponent component: this.components) {
            component.showDetails();
        }
    }
}