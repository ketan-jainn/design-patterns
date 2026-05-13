/** Bridge: abstraction (Shape) separated from implementor (Renderer). */
interface Renderer {
    void renderCircle(float r);
}

class VectorRenderer implements Renderer {
    public void renderCircle(float r) {
        System.out.println("Vector circle r=" + r);
    }
}

class RasterRenderer implements Renderer {
    public void renderCircle(float r) {
        System.out.println("Raster circle r=" + r);
    }
}

abstract class Shape {
    protected final Renderer renderer;

    Shape(Renderer renderer) {
        this.renderer = renderer;
    }

    abstract void draw();
}

class Circle extends Shape {
    private final float radius;

    Circle(Renderer renderer, float radius) {
        super(renderer);
        this.radius = radius;
    }

    void draw() {
        renderer.renderCircle(radius);
    }
}

public class BridgeDemo {
    public static void main(String[] args) {
        Shape c = new Circle(new VectorRenderer(), 2.5f);
        c.draw();
    }
}
