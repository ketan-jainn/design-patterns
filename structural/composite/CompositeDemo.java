/** Composite: tree where leaves and branches share operations. */
interface Node {
    String name();

    int sizeBytes();
}

class FileLeaf implements Node {
    private final String name;
    private final int size;

    FileLeaf(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public int sizeBytes() {
        return size;
    }
}

class Folder implements Node {
    private final String name;
    private final java.util.List<Node> children = new java.util.ArrayList<>();

    Folder(String name) {
        this.name = name;
    }

    void add(Node n) {
        children.add(n);
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public int sizeBytes() {
        int sum = 0;
        for (Node c : children) {
            sum += c.sizeBytes();
        }
        return sum;
    }
}

public class CompositeDemo {
    public static void main(String[] args) {
        Folder root = new Folder("root");
        root.add(new FileLeaf("a.txt", 10));
        Folder sub = new Folder("docs");
        sub.add(new FileLeaf("b.txt", 5));
        root.add(sub);
        System.out.println(root.name() + " total=" + root.sizeBytes());
    }
}
