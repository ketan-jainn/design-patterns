/** Factory Method: subclasses decide concrete product. */
interface Button {
    void render();
}

class WindowsButton implements Button {
    @Override
    public void render() {
        System.out.println("Windows button");
    }
}

class WebButton implements Button {
    @Override
    public void render() {
        System.out.println("Web button");
    }
}

abstract class Dialog {
    abstract Button createButton();

    void paint() {
        Button b = createButton();
        b.render();
    }
}

class WindowsDialog extends Dialog {
    @Override
    Button createButton() {
        return new WindowsButton();
    }
}

class WebDialog extends Dialog {
    @Override
    Button createButton() {
        return new WebButton();
    }
}

public class FactoryMethodDemo {
    public static void main(String[] args) {
        Dialog d = new WebDialog();
        d.paint();
    }
}
