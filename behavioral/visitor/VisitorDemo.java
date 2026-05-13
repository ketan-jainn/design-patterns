/** Visitor: external operation over a stable element hierarchy (double dispatch). */
interface Visitor {
    void visitDot(Dot d);

    void visitLine(Line l);
}

interface Shape {
    void accept(Visitor v);
}

class Dot implements Shape {
    int x, y;

    Dot(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void accept(Visitor v) {
        v.visitDot(this);
    }
}

class Line implements Shape {
    int x1, y1, x2, y2;

    Line(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public void accept(Visitor v) {
        v.visitLine(this);
    }
}

class SvgExportVisitor implements Visitor {
    private final StringBuilder sb = new StringBuilder();

    @Override
    public void visitDot(Dot d) {
        sb.append(String.format("<circle cx='%d' cy='%d' r='1'/>", d.x, d.y));
    }

    @Override
    public void visitLine(Line l) {
        sb.append(String.format("<line x1='%d' y1='%d' x2='%d' y2='%d'/>", l.x1, l.y1, l.x2, l.y2));
    }

    String svg() {
        return "<svg>" + sb + "</svg>";
    }
}

public class VisitorDemo {
    public static void main(String[] args) {
        Shape[] doc = {new Dot(1, 2), new Line(0, 0, 5, 5)};
        SvgExportVisitor v = new SvgExportVisitor();
        for (Shape s : doc) {
            s.accept(v);
        }
        System.out.println(v.svg());
    }
}
