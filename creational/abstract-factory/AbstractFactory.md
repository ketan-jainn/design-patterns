---
tags: [design-patterns, creational, abstract-factory]
aliases: [Abstract Factory pattern, README]
---

# Abstract Factory

## Jugaad cue

| Signal | Close-your-eyes pick |
|--------|----------------------|
| You must ship **matching** widgets/themes (button + checkbox + toolbar style **never mixed**) | One factory object = one whole family (Win vs Mac kit) |

**Intent:** Provide an interface for creating **families** of related or dependent objects without specifying their concrete classes.

## When to use

- Need **consistent** UI kits, themes, or platform bundles (button + checkbox + menu from same family).
- Configuration chooses the whole factory once.

## When to avoid

- Adding a *new kind of product* forces changes across every factory implementation.

## Trade-offs

- **Pros:** Enforces compatibility within a family; swaps whole look/feel.
- **Cons:** Interface churn when the product set grows.

## Often confused with

- **Factory Method** — one product line vs coordinated **multiple** products.

## Tiny code snapshot

From `AbstractFactoryDemo.java` — one factory builds a **matching** pair:

```java
interface UIFactory {
    Button createButton();
    Checkbox createCheckbox();
}

class Application {
    private final Button button;
    private final Checkbox checkbox;

    Application(UIFactory factory) {
        button = factory.createButton();
        checkbox = factory.createCheckbox();
    }
}
```

## Files

| File | Role |
|------|------|
| `AbstractFactoryDemo.java` | `UIFactory` + Mac/Win families |

## Run

```bash
cd creational/abstract-factory
javac AbstractFactoryDemo.java
java AbstractFactoryDemo
```

## 30-second interview

“Abstract Factory groups creation APIs so a client never mixes Mac buttons with Windows checkboxes—one factory instance represents one theme or platform.”

## Related

- [[../factory-method/FactoryMethod]] — often each product still uses factory method internally.
- [[../../structural/facade/Facade]] — both simplify a surface; Abstract Factory is about **creation families**.
