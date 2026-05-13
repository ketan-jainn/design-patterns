---
tags: [design-patterns, creational, singleton]
aliases: [Singleton pattern, README]
---

# Singleton

## Jugaad cue

| Signal | Close-your-eyes pick |
|--------|----------------------|
| The domain literally requires **one instance per JVM** (not “I want one bean”) | Enum singleton, tiny process-wide resource |
| “Everyone should share this mutable global” | **Stop**—reach for **dependency injection** / scoped instance instead |

**Intent:** Ensure a class has **at most one** instance and provide global access.

## When to use

- True process-wide coordination (e.g. logging sink, connection pool *facade*—often still prefer DI).
- Hardware or OS singleton semantics.

## When to avoid

- Most application “services” (prefer **injection** and a single binding in your container).
- Unit tests (global mutable state hurts parallel tests).

## Trade-offs

- **Pros:** Single locus of control; lazy init possible.
- **Cons:** Hidden dependencies, threading in classic lazy holder, subclassing awkward.

## Often confused with

- **Static util class** — no instance / no polymorphism.
- **Spring `@Bean` singleton scope** — framework-managed, not GoF Singleton.

## Tiny code snapshot

From `SingletonDemo.java` — enum singleton (Java-preferred):

```java
enum AppConfig {
    INSTANCE;

    private String theme = "light";

    public void setTheme(String theme) {
        this.theme = theme;
    }
}

// AppConfig.INSTANCE == AppConfig.INSTANCE  → always true
```

## Files

| File | Role |
|------|------|
| `SingletonDemo.java` | Enum singleton + classic pattern sketch |

## Run

```bash
cd creational/singleton
javac SingletonDemo.java
java SingletonDemo
```

## 30-second interview

“Singleton guarantees one instance in a JVM. In Java I prefer **enum singleton** for serialization/thread-safety. In large apps I avoid GoF Singleton and use **dependency injection** with one scoped instance instead.”

## Related

- [[../factory-method/FactoryMethod]] — creation extensibility without global instance.
