---
tags: [design-patterns, structural, decorator]
aliases: [Decorator pattern, README]
---

# Decorator

## Jugaad cue

| Signal | Close-your-eyes pick |
|--------|----------------------|
| Features **stack** (same type, order matters): compression → encryption → logging | Wrapper implements same interface, delegates + adds before/after |

**Intent:** Attach **additional responsibilities** to an object **dynamically**. Decorators provide a flexible alternative to subclassing for extending functionality.

## When to use

- Compose features in **any order** (I/O streams, HTTP middleware, UI borders).
- Want to obey **Open/Closed** without subclass explosion.

## When to avoid

- Object identity matters (`==`); decorators wrap and change identity unless carefully designed.

## Trade-offs

- **Pros:** Composable; each decorator is small and focused.
- **Cons:** Ordering can matter; deep stacks harder to debug.

## Often confused with

- **Adapter** — Decorator keeps the **same** abstract type; Adapter maps to a **different** one.
- **Chain of Responsibility** — chain passes until handled; decorator **always** wraps call.

## Tiny code snapshot

From `DecoratorDemo.java` — same `Beverage` type, wrappers stack:

```java
abstract class BeverageDecorator implements Beverage {
    protected final Beverage inner;
    // ...
}

// Order: outer wraps inner
Beverage b = new Whip(new Milk(new Coffee()));
```

## Files

| File | Role |
|------|------|
| `DecoratorDemo.java` | `Coffee` + milk/whip decorators |

## Run

```bash
cd structural/decorator
javac DecoratorDemo.java
java DecoratorDemo
```

## 30-second interview

“Decorator wraps a component and forwards calls while adding behavior—like Java’s `BufferedInputStream` wrapping another `InputStream`.”

## Related

- [[../proxy/Proxy]] — proxy often **controls access**; decorator **adds features** (intent differs).
