package MementoPattern.Example;/* A text editor where user can undo changes, such as text addition, deletion
or formatting. The editor stores snapshots of its state (text content)
after each change, enabling the user to revert to previous states.*/

public class TextEditor {
    private String content; // main attribute to store entire text
    // can have other attributes -> author, heading, etc...

    // Store all the past states for the content -> if we do here SRP is violated
    // Manage State separately

    public void write(String text) {
        this.content = text;
    }

    // Save current state of editor
    public EditorMemento save() {
        return new EditorMemento(content);
    }

    // Restore (Memento -> update state of current content)
    public void restore(EditorMemento memento) {
        this.content = memento.getContent();
    }

    public String getContent() {
        return this.content;
    }
}