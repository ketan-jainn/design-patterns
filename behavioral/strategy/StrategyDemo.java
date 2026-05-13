/** Strategy: interchangeable algorithms (payment types). */
interface PaymentStrategy {
    void pay(int amountCents);
}

class CardPayment implements PaymentStrategy {
    @Override
    public void pay(int amountCents) {
        System.out.println("Card charged " + amountCents + " cents");
    }
}

class WalletPayment implements PaymentStrategy {
    @Override
    public void pay(int amountCents) {
        System.out.println("Wallet debited " + amountCents + " cents");
    }
}

class Checkout {
    private PaymentStrategy strategy = new CardPayment();

    void setPaymentStrategy(PaymentStrategy s) {
        strategy = s;
    }

    void complete(int amountCents) {
        strategy.pay(amountCents);
    }
}

public class StrategyDemo {
    public static void main(String[] args) {
        Checkout c = new Checkout();
        c.complete(999);
        c.setPaymentStrategy(new WalletPayment());
        c.complete(500);
    }
}
