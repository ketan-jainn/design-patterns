/** Command: encapsulate action as object for invoker/queue/undo hooks. */
interface Command {
    void execute();
}

class Light {
    void on() {
        System.out.println("Light ON");
    }
}

class LightOnCommand implements Command {
    private final Light light;

    LightOnCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.on();
    }
}

class Remote {
    void press(Command cmd) {
        cmd.execute();
    }
}

public class CommandDemo {
    public static void main(String[] args) {
        Light light = new Light();
        Remote remote = new Remote();
        remote.press(new LightOnCommand(light));
    }
}
