---
tags: [design-patterns, behavioral, memento]
aliases: [Memento pattern, README]
---

# Memento

## Jugaad cue

| Signal | Close-your-eyes pick |
|--------|----------------------|
| **Undo / checkpoint** but you don’t want `public` getters for every private field | Originator hands opaque memento to caretaker stack |

**Intent:** Without violating encapsulation, **capture and externalize** an object’s internal state so that the object can be **restored** to this state later.

## When to use

- **Undo stacks**, transactional editors, game save slots.
- Need snapshots without exposing private fields.

## When to avoid

- Huge object graphs where deep snapshots are expensive—consider event sourcing deltas.

## Trade-offs

- **Pros:** Clean separation: originator, memento, caretaker roles.
- **Cons:** Memory/time for snapshots; wide mementos if everything is copied.

## Often confused with

- **Command** — Command stores *operation*; Memento stores *state snapshot* (often used together for undo).

## Tiny code snapshot

From `MementoDemo.java` — caretaker stores opaque snapshots:

```java
EditorMemento save() {
    return new EditorMemento(text);
}

void restore(EditorMemento m) {
    text = m.text();
}
```

## Files

| File | Role |
|------|------|
| `MementoDemo.java` | `Editor` + `History` caretaker |

## Run

```bash
cd behavioral/memento
javac MementoDemo.java
java MementoDemo
```

## 30-second interview

“Originator creates a memento with private state; caretaker stores mementos without peeking; restore replays internal fields—classic undo buffer.”

## Related

- [[../command/Command]] — command + memento for reversible ops.
