/** Memento: snapshot internal state for later restore without exposing fields. */
final class EditorMemento {
    private final String text;

    EditorMemento(String text) {
        this.text = text;
    }

    String text() {
        return text;
    }
}

class Editor {
    private String text = "";

    void type(String s) {
        text += s;
    }

    String getText() {
        return text;
    }

    EditorMemento save() {
        return new EditorMemento(text);
    }

    void restore(EditorMemento m) {
        text = m.text();
    }
}

class History {
    private final java.util.Deque<EditorMemento> stack = new java.util.ArrayDeque<>();

    void push(EditorMemento m) {
        stack.push(m);
    }

    EditorMemento pop() {
        return stack.pop();
    }
}

public class MementoDemo {
    public static void main(String[] args) {
        Editor e = new Editor();
        History h = new History();
        e.type("hi");
        h.push(e.save());
        e.type(" world");
        System.out.println(e.getText());
        e.restore(h.pop());
        System.out.println(e.getText());
    }
}
