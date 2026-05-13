/** Decorator: stack behaviors while preserving component interface. */
interface Beverage {
    String describe();

    int costCents();
}

class Coffee implements Beverage {
    @Override
    public String describe() {
        return "Coffee";
    }

    @Override
    public int costCents() {
        return 200;
    }
}

abstract class BeverageDecorator implements Beverage {
    protected final Beverage inner;

    BeverageDecorator(Beverage inner) {
        this.inner = inner;
    }
}

class Milk extends BeverageDecorator {
    Milk(Beverage inner) {
        super(inner);
    }

    @Override
    public String describe() {
        return inner.describe() + " + Milk";
    }

    @Override
    public int costCents() {
        return inner.costCents() + 40;
    }
}

class Whip extends BeverageDecorator {
    Whip(Beverage inner) {
        super(inner);
    }

    @Override
    public String describe() {
        return inner.describe() + " + Whip";
    }

    @Override
    public int costCents() {
        return inner.costCents() + 50;
    }
}

public class DecoratorDemo {
    public static void main(String[] args) {
        Beverage b = new Whip(new Milk(new Coffee()));
        System.out.println(b.describe() + " = " + b.costCents() + " cents");
    }
}
