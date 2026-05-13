/** Template Method: algorithm skeleton in base, subclasses fill hooks. */
abstract class DataImporter {
    final void importFile(String path) {
        byte[] raw = read(path);
        String text = decode(raw);
        validate(text);
        save(text);
    }

    private byte[] read(String path) {
        System.out.println("read " + path);
        return path.getBytes();
    }

    protected abstract String decode(byte[] raw);

    protected void validate(String text) {
        if (text.isEmpty()) {
            throw new IllegalArgumentException("empty");
        }
    }

    private void save(String text) {
        System.out.println("saved: " + text);
    }
}

class Utf8Importer extends DataImporter {
    protected String decode(byte[] raw) {
        return new String(raw, java.nio.charset.StandardCharsets.UTF_8);
    }
}

public class TemplateMethodDemo {
    public static void main(String[] args) {
        new Utf8Importer().importFile("hello");
    }
}
