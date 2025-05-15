// The GraphicEditor class manages the properties of shapes and provides functionality to save and restore their state using the Memento pattern.

package MementoPattern.Exercise;

public class GraphicEditor {
    
    private String shapeType;
    private int x;
    private int y;
    private String color;
    private int size;

    public EditorMemento save() {
        // TODO: Create and return a new memento that captures the current state of the shape attributes.
        return new EditorMemento(shapeType, x, y, color, size);
    }

    public void restore(EditorMemento memento) {
        // TODO: Restore the shape attributes from the provided memento, updating the graphic editor's state.
        this.shapeType = memento.getShapeType();
        this.x = memento.getX();
        this.y = memento.getY();
        this.color = memento.getColor();
        this.size = memento.getSize();
    }

    public String getShape() {
        return "Shape: " + shapeType + ", Position: (" + x + ", " + y + "), Color: " + color + ", Size: " + size;
    }

    public void setShape(String shapeType, int x, int y, String color, int size) {
        this.shapeType = shapeType;
        this.x = x;
        this.y = y;
        this.color = color;
        this.size = size;
    }
}
