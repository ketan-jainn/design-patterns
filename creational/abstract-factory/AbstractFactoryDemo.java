/** Abstract Factory: families of related UI widgets. */
interface Button {
    void paint();
}

interface Checkbox {
    void paint();
}

interface UIFactory {
    Button createButton();

    Checkbox createCheckbox();
}

class WinButton implements Button {
    @Override
    public void paint() {
        System.out.println("WinButton");
    }
}

class WinCheckbox implements Checkbox {
    @Override
    public void paint() {
        System.out.println("WinCheckbox");
    }
}

class MacButton implements Button {
    @Override
    public void paint() {
        System.out.println("MacButton");
    }
}

class MacCheckbox implements Checkbox {
    @Override
    public void paint() {
        System.out.println("MacCheckbox");
    }
}

class WindowsUIFactory implements UIFactory {
    @Override
    public Button createButton() {
        return new WinButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WinCheckbox();
    }
}

class MacUIFactory implements UIFactory {
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}

class Application {
    private final Button button;
    private final Checkbox checkbox;

    Application(UIFactory factory) {
        button = factory.createButton();
        checkbox = factory.createCheckbox();
    }

    void paint() {
        button.paint();
        checkbox.paint();
    }
}

public class AbstractFactoryDemo {
    public static void main(String[] args) {
        UIFactory f = new MacUIFactory();
        new Application(f).paint();
    }
}
