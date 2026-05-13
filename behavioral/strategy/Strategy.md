---
tags: [design-patterns, behavioral, strategy]
aliases: [Strategy pattern, README]
---

# Strategy

## Jugaad cue

| Signal                                                                     | Close-your-eyes pick                                                     |
| -------------------------------------------------------------------------- | ------------------------------------------------------------------------ |
| Big `switch`/if on **which algorithm** (tax, shipping, payment) at runtime | Inject `Strategy` interface; swap implementation without touching caller |

**Intent:** Define a family of **algorithms**, encapsulate each one, and make them **interchangeable**.

## When to use

- Runtime choice among policies (pricing, shipping, compression).
- Want to **test** algorithms in isolation without mocking the whole world.

## When to avoid

- Algorithm never changes—YAGNI.

## Trade-offs

- **Pros:** Replaces conditional spaghetti; Open/Closed for new strategies.
- **Cons:** More objects; wiring can feel verbose without DI.

## Often confused with

- **State** — Strategy clients usually **choose** policy; State **transitions** follow internal rules.
- **Template Method** — inheritance skeleton vs **composition** of strategies.

## Tiny code snapshot

From `StrategyDemo.java` — context delegates to a pluggable strategy:

```java
interface PaymentStrategy {
    void pay(int amountCents);
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
```

## Files

| File | Role |
|------|------|
| `StrategyDemo.java` | `Checkout` + `PaymentStrategy` |

## Run

```bash
cd behavioral/strategy
javac StrategyDemo.java
java StrategyDemo
```

## 30-second interview

“Strategy pulls `if/else` payment logic into pluggable objects implementing a common interface—context delegates at runtime.”

## Related

- [[../template-method/TemplateMethod]] — inheritance vs composition.
- [[../state/State]] — modes vs policies.
