package CommandPattern;

class TextEditor {
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

// UI Button classes
class BoldButton {
    private TextEditor editor; // reference to text editor to bold text

    public BoldButton(TextEditor editor) {
        this.editor = editor;
    }

    public void click() {
        editor.boldText();
    }
}

class ItalicizeButton {
    private TextEditor editor; // reference to text editor to italicize text

    public ItalicizeButton(TextEditor editor) {
        this.editor = editor;
    }

    public void click() {
        editor.italicizeText();
    }
}

class UnderlineButton {
    private TextEditor editor; // reference to text editor to underline text

    public UnderlineButton(TextEditor editor) {
        this.editor = editor;
    }

    public void click() {
        editor.underlineText();
    }
}

public class WithoutCommandPattern {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        BoldButton boldButton = new BoldButton(editor);
        ItalicizeButton italicizeButton = new ItalicizeButton(editor);
        UnderlineButton underlineButton = new UnderlineButton(editor);

        // performing click operation
        boldButton.click();
        italicizeButton.click();
        underlineButton.click();

        // Problems:
        // 1. Redundant code
        // 2. Tightly coupled -> if action changes all button classes need to be modified

        // Solution is command pattern -> one button can perform multiple actions
    }
}