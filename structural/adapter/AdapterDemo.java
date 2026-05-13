/** Adapter: wrap incompatible interface behind expected one. */
interface JsonParser {
    String parseJson(String input);
}

/** Legacy component we cannot change. */
class LegacyXmlParser {
    String parseXml(String xml) {
        return "parsed-xml:" + xml;
    }
}

class XmlToJsonAdapter implements JsonParser {
    private final LegacyXmlParser legacy = new LegacyXmlParser();

    public String parseJson(String input) {
        return legacy.parseXml("<root>" + input + "</root>");
    }
}

public class AdapterDemo {
    public static void main(String[] args) {
        JsonParser p = new XmlToJsonAdapter();
        System.out.println(p.parseJson("payload"));
    }
}
