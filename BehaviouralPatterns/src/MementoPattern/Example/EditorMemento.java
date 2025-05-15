package MementoPattern.Example;

// Memento Class: Stores the state of text editor
public class EditorMemento {
    private final String content;

    public EditorMemento(String content) {
        this.content = content;
    }

    public String getContent() {
        return this.content;
    }
}