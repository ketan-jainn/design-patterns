/** Chain of Responsibility: handlers pass request along until one handles it. */
abstract class SupportHandler {
    private SupportHandler next;

    SupportHandler setNext(SupportHandler n) {
        next = n;
        return n;
    }

    final void handle(String issue) {
        if (canHandle(issue)) {
            resolve(issue);
        } else if (next != null) {
            next.handle(issue);
        } else {
            System.out.println("escalate: no handler for " + issue);
        }
    }

    protected abstract boolean canHandle(String issue);

    protected abstract void resolve(String issue);
}

class L1 extends SupportHandler {
    protected boolean canHandle(String issue) {
        return issue.startsWith("password");
    }

    protected void resolve(String issue) {
        System.out.println("L1 fixed: " + issue);
    }
}

class L2 extends SupportHandler {
    protected boolean canHandle(String issue) {
        return issue.startsWith("billing");
    }

    protected void resolve(String issue) {
        System.out.println("L2 fixed: " + issue);
    }
}

public class ChainDemo {
    public static void main(String[] args) {
        L1 l1 = new L1();
        l1.setNext(new L2());
        l1.handle("password reset");
        l1.handle("billing dispute");
    }
}
