/** Flyweight: reuse immutable glyph objects; position is extrinsic. */
import java.util.HashMap;
import java.util.Map;

final class GlyphFlyweight {
    private final char ch;

    GlyphFlyweight(char ch) {
        this.ch = ch;
    }

    void drawAt(int x, int y) {
        System.out.println("draw '" + ch + "' @" + x + "," + y);
    }
}

class GlyphFactory {
    private final Map<Character, GlyphFlyweight> pool = new HashMap<>();

    GlyphFlyweight get(char c) {
        return pool.computeIfAbsent(c, GlyphFlyweight::new);
    }

    int poolSize() {
        return pool.size();
    }
}

public class FlyweightDemo {
    public static void main(String[] args) {
        GlyphFactory f = new GlyphFactory();
        String text = "toast";
        int x = 0;
        for (char c : text.toCharArray()) {
            f.get(c).drawAt(x++, 0);
        }
        System.out.println("pool size=" + f.poolSize());
    }
}
