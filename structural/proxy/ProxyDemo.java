/** Proxy: control access (lazy load) to expensive subject. */
interface Image {
    void display();
}

class RealImage implements Image {
    private final String file;

    RealImage(String file) {
        this.file = file;
        loadFromDisk();
    }

    private void loadFromDisk() {
        System.out.println("Loading " + file);
    }

    public void display() {
        System.out.println("Display " + file);
    }
}

class ProxyImage implements Image {
    private final String file;
    private RealImage real;

    ProxyImage(String file) {
        this.file = file;
    }

    public void display() {
        if (real == null) {
            real = new RealImage(file);
        }
        real.display();
    }
}

public class ProxyDemo {
    public static void main(String[] args) {
        Image img = new ProxyImage("photo.png");
        System.out.println("constructed (no load yet)");
        img.display();
        img.display();
    }
}
