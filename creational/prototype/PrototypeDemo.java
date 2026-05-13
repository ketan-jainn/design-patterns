/** Prototype: duplicate by copying an existing instance. */
class Circle implements Cloneable {
    int x, y, radius;

    Circle(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public Circle clone() {
        try {
            return (Circle) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    @Override
    public String toString() {
        return "Circle(" + x + "," + y + ", r=" + radius + ")";
    }
}

public class PrototypeDemo {
    public static void main(String[] args) {
        Circle template = new Circle(0, 0, 5);
        Circle c2 = template.clone();
        c2.x = 10;
        System.out.println(template);
        System.out.println(c2);
    }
}
