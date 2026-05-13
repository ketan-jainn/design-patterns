/** Mediator: colleagues communicate through hub, not pairwise. */
import java.util.ArrayList;
import java.util.List;

interface ChatMediator {
    void broadcast(String from, String msg);
}

class ChatRoom implements ChatMediator {
    private final List<User> users = new ArrayList<>();

    void join(User u) {
        users.add(u);
    }

    public void broadcast(String from, String msg) {
        for (User u : users) {
            if (!u.name().equals(from)) {
                u.receive(from, msg);
            }
        }
    }
}

class User {
    private final String name;
    private final ChatMediator room;

    User(String name, ChatMediator room) {
        this.name = name;
        this.room = room;
    }

    String name() {
        return name;
    }

    void send(String msg) {
        room.broadcast(name, msg);
    }

    void receive(String from, String msg) {
        System.out.println(name + " <- " + from + ": " + msg);
    }
}

public class MediatorDemo {
    public static void main(String[] args) {
        ChatRoom room = new ChatRoom();
        User a = new User("Ann", room);
        User b = new User("Bob", room);
        room.join(a);
        room.join(b);
        a.send("hi all");
    }
}
