package CommandPattern;

// Command Interface
interface Command {
    void execute();
}

// Concrete classes for Commands
class BoldCommand implements Command {
    private TextEditor2 editor;

    public BoldCommand(TextEditor2 editor) {
        this.editor = editor;
    }

    @Override
    public void execute() {
        editor.boldText();
    }
}

class ItalicizeCommand implements Command {
    private TextEditor2 editor;

    public ItalicizeCommand(TextEditor2 editor) {
        this.editor = editor;
    }

    @Override
    public void execute() {
        editor.italicizeText();
    }
}

class UnderlineCommand implements Command {
    private TextEditor2 editor;

    public UnderlineCommand(TextEditor2 editor) {
        this.editor = editor;
    }

    @Override
    public void execute() {
        editor.underlineText();
    }
}

// UI component
class Button {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void click() {
        command.execute();
    }
}

// Receiver: Text editor
class TextEditor2 {
    public void boldText() {
        System.out.println("Text has been bolded");
    }

    public void italicizeText() {
        System.out.println("Text has been italicized");
    }

    public void underlineText() {
        System.out.println("Text has been underlined");
    }
}

public class WithCommandPattern {
    public static void main(String[] args) {
        // Idea is to decouple the actions from UI button
        // Buttons can work with generic Command objects

        TextEditor2 editor2 = new TextEditor2();

        // Button
        // Decoupling -> one button can do many types of actions
        Button button = new Button();
        button.setCommand(new BoldCommand(editor2));

        button.click();
    }
}