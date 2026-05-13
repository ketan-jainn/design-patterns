---
tags: [design-patterns, creational, prototype]
aliases: [Prototype pattern, README]
---

# Prototype

## Jugaad cue

| Signal | Close-your-eyes pick |
|--------|----------------------|
| “Start from **this** filled-in object” / clone is cheaper than rebuilding a graph | `clone()` / copy constructor + prototype registry |

**Intent:** Specify the kinds of objects to create using a **prototypical instance**, and create new objects by **copying** this prototype.

## When to use

- Cloning is **cheaper or simpler** than rebuilding from scratch.
- Want to avoid subclass explosion for similar configurations (registry of templates).

## When to avoid

- Deep graphs where copy semantics are error-prone; consider serialization libraries or builders.

## Trade-offs

- **Pros:** Hides concrete classes from client; fast duplication of heavy templates.
- **Cons:** Clone vs deep copy; mutable shared sub-objects.

## Often confused with

- **Factory** — Prototype is about **copy**; factories are about **construction** rules.

## Tiny code snapshot

From `PrototypeDemo.java` — clone as a new starting point:

```java
class Circle implements Cloneable {
    @Override
    public Circle clone() {
        try {
            return (Circle) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }
}
```

## Files

| File | Role |
|------|------|
| `PrototypeDemo.java` | `clone()`-style hand copy for a simple shape |

## Run

```bash
cd creational/prototype
javac PrototypeDemo.java
java PrototypeDemo
```

## 30-second interview

“Prototype clones a template object instead of calling a long constructor chain—watch deep vs shallow copy for nested mutable fields.”

## Related

- [[../builder/Builder]] — when stepwise construction fits better than cloning.
