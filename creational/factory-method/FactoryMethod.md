---
tags: [design-patterns, creational, factory-method]
aliases: [Factory Method pattern, README]
---

# Factory Method

## Jugaad cue

| Signal | Close-your-eyes pick |
|--------|----------------------|
| Framework calls `render()` but **which `Button`** should be created depends on platform | Override `createButton()` (or similar) in a subclass—don’t hardcode `new` in the base |

**Intent:** Define an interface for creating an object, but let **subclasses** decide which class to instantiate.

## When to use

- Framework code needs to create objects from a family, but the exact type should be **extensible** without changing framework code.
- You want hooks (`createProduct()`) instead of hard-coded `new Concrete()`.

## When to avoid

- Object graph is simple and stable—constructors or static factories suffice.

## Trade-offs

- **Pros:** Follows Open/Closed for new product types via new subclasses.
- **Cons:** Class explosion (one creator subclass per variant).

## Often confused with

- **Abstract Factory** — Factory Method is usually *one* product; Abstract Factory builds *families* of related products.

## Tiny code snapshot

From `FactoryMethodDemo.java` — subclass supplies the concrete product:

```java
abstract class Dialog {
    abstract Button createButton();

    void paint() {
        Button b = createButton();
        b.render();
    }
}

class WebDialog extends Dialog {
    Button createButton() {
        return new WebButton();
    }
}
```

## Files

| File | Role |
|------|------|
| `FactoryMethodDemo.java` | `Dialog` + `createButton()` hook |

## Run

```bash
cd creational/factory-method
javac FactoryMethodDemo.java
java FactoryMethodDemo
```

## 30-second interview

“Factory Method moves `new` behind a method so subclasses pick the concrete type. The framework calls `render()`; `createButton()` is overridden for Windows vs Web.”

## Related

- [[../abstract-factory/AbstractFactory]] — families of products.
- [[../singleton/Singleton]] — orthogonal; creation vs single instance.
