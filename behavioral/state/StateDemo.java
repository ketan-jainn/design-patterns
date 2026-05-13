/** State: behavior changes when context's state object changes. */
interface TurnstileState {
    void coin(Turnstile t);

    void push(Turnstile t);
}

class LockedState implements TurnstileState {
    @Override
    public void coin(Turnstile t) {
        System.out.println("unlock");
        t.setState(new UnlockedState());
    }

    @Override
    public void push(Turnstile t) {
        System.out.println("locked: push ignored");
    }
}

class UnlockedState implements TurnstileState {
    @Override
    public void coin(Turnstile t) {
        System.out.println("already unlocked");
    }

    @Override
    public void push(Turnstile t) {
        System.out.println("pass");
        t.setState(new LockedState());
    }
}

class Turnstile {
    private TurnstileState state = new LockedState();

    void setState(TurnstileState s) {
        state = s;
    }

    void coin() {
        state.coin(this);
    }

    void push() {
        state.push(this);
    }
}

public class StateDemo {
    public static void main(String[] args) {
        Turnstile t = new Turnstile();
        t.push();
        t.coin();
        t.push();
        t.push();
    }
}
