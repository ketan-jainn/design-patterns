/** Observer: subject notifies many dependents on change. */
import java.util.ArrayList;
import java.util.List;

interface Subscriber {
    void onNews(String headline);
}

class NewsAgency {
    private final List<Subscriber> subs = new ArrayList<>();
    private String latest = "";

    void subscribe(Subscriber s) {
        subs.add(s);
    }

    void publish(String headline) {
        latest = headline;
        for (Subscriber s : subs) {
            s.onNews(latest);
        }
    }
}

class PhoneApp implements Subscriber {
    @Override
    public void onNews(String headline) {
        System.out.println("Phone push: " + headline);
    }
}

class WebApp implements Subscriber {
    @Override
    public void onNews(String headline) {
        System.out.println("Web refresh: " + headline);
    }
}

public class ObserverDemo {
    public static void main(String[] args) {
        NewsAgency n = new NewsAgency();
        n.subscribe(new PhoneApp());
        n.subscribe(new WebApp());
        n.publish("Strategy pattern shipped");
    }
}
