package MementoPattern.Example;

public class TextEditorMain {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        Caretaker caretaker = new Caretaker(); // History / State mgmt

        editor.write("A");
        caretaker.saveState(editor);

        editor.write("B");
        caretaker.saveState(editor);

        editor.write("C");
        caretaker.saveState(editor);

        // Problem -> Undo the last write
        System.out.println("Current: " + editor.getContent());
        caretaker.undo(editor);
        System.out.println("After undo: " + editor.getContent());
    }
}