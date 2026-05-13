/** Builder: fluent construction of a complex immutable object. */
final class HttpRequest {
    private final String method;
    private final String url;
    private final String body;

    private HttpRequest(String method, String url, String body) {
        this.method = method;
        this.url = url;
        this.body = body;
    }

    static class Builder {
        private String method = "GET";
        private String url = "";
        private String body = "";

        Builder method(String m) {
            method = m;
            return this;
        }

        Builder url(String u) {
            url = u;
            return this;
        }

        Builder body(String b) {
            body = b;
            return this;
        }

        HttpRequest build() {
            if (url == null || url.isEmpty()) {
                throw new IllegalStateException("url required");
            }
            return new HttpRequest(method, url, body);
        }
    }

    public String toString() {
        return method + " " + url + (body.isEmpty() ? "" : " | " + body);
    }
}

public class BuilderDemo {
    public static void main(String[] args) {
        HttpRequest r =
                new HttpRequest.Builder()
                        .method("POST")
                        .url("/api/orders")
                        .body("{\"id\":1}")
                        .build();
        System.out.println(r);
    }
}
