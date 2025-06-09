package AbstractFactoryPattern.Solution;

// Step 1: To avoid Tight coupling -> Abstract product interfaces
interface Button {
    void render();
}
interface Scrollbar {
    void scroll();
}


// Step 2: Abstract Factory
interface UIFactory {
    Button createButton();
    Scrollbar createScrollbar();
}

// Windows UI components
class WindowsButton implements Button {
    public void render() {
        System.out.println("Rendering Windows button");
    }
}
class WindowsScrollbar implements Scrollbar{
    public void scroll() {
        System.out.println("Scrolling Windows scrollbar");
    }
}

// Mac UI components
class MacOSButton implements Button{
    public void render() {
        System.out.println("Rendering MacOS button");
    }
}
class MacOSScrollbar implements Scrollbar{
    public void scroll() {
        System.out.println("Scrolling MacOS scrollbar");
    }
}


// Step 3: Concrete Implementations
class WindowsFactory implements UIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Scrollbar createScrollbar() {
        return new WindowsScrollbar();
    }
}

class MacOSFactory implements UIFactory {

    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public Scrollbar createScrollbar() {
        return new MacOSScrollbar();
    }
}

public class Application {
    private final Button button;
    private final Scrollbar scrollbar;

    public Application(UIFactory factory) {
        this.button = factory.createButton();
        this.scrollbar = factory.createScrollbar();
    }

    public void renderUI() {
        this.button.render();
        this.scrollbar.scroll();
    }

    public static void main(String[] args) {
        // Use Windows UI
        UIFactory windowsFactory = new WindowsFactory();
        Application app = new Application(windowsFactory);
        app.renderUI();

        // we can easily switch b/w ui by supplying the factory
        // Application app = new Application(new MacOSFactory());
        // app.renderUI();
    }
}