package AbstractFactoryPattern.Problem;

// Windows UI components
class WindowsButton {
    public void render() {
        System.out.println("Rendering Windows button");
    }
}

class WindowsScrollbar {
    public void scroll() {
        System.out.println("Scrolling Windows scrollbar");
    }
}

// Mac UI components
class MacOSButton {
    public void render() {
        System.out.println("Rendering MacOS button");
    }
}

class MacOSScrollbar {
    public void sroll() {
        System.out.println("Scrolling MacOS scrollbar");
    }
}
public class Application {
    public static void main(String[] args) {
        // Windows UI
        WindowsButton  windowsButton = new WindowsButton();
        WindowsScrollbar windowsScrollbar = new WindowsScrollbar();

        // Problems
        // 1. Should not be possible -> Logically inconsistent
        // MacOSScrollbar macOSScrollbar = new MacOSScrollbar();

        // 2. Tight coupling -> with concrete classes
        // 3. Hard to extend -> modify code for Mac UI

        windowsButton.render();
        windowsScrollbar.scroll();
    }
}