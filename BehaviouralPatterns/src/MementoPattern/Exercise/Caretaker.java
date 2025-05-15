// The Caretaker class manages the history of shape states, allowing for saving and undoing changes in the Memento pattern.

package MementoPattern.Exercise;

import java.util.Stack;

public class Caretaker {
    
    private final Stack<EditorMemento> history = new Stack<>();

    public void saveState(GraphicEditor graphicEditor) {
        // TODO: Save the current state of the graphic editor by pushing its memento onto the history stack.
        history.push(graphicEditor.save());
    }

    public void undo(GraphicEditor graphicEditor){
        // TODO: Restore the last saved state of the graphic editor if history is not empty.
        if(!history.isEmpty()) {
            history.pop();
            graphicEditor.restore(history.peek());
        }
    }
}
