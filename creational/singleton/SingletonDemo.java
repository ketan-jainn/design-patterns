/** Enum singleton: preferred in Java (serialization + thread-safe). */
enum AppConfig {
    INSTANCE;

    private String theme = "light";

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }
}

public class SingletonDemo {
    public static void main(String[] args) {
        AppConfig a = AppConfig.INSTANCE;
        AppConfig b = AppConfig.INSTANCE;
        a.setTheme("dark");
        System.out.println(b.getTheme());
        System.out.println("same ref? " + (a == b));
    }
}
