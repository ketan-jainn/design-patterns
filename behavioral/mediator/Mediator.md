---
tags: [design-patterns, behavioral, mediator]
aliases: [Mediator pattern, README]
---

# Mediator

## Jugaad cue

| Signal | Close-your-eyes pick |
|--------|----------------------|
| **N widgets** would otherwise reference each other in a spaghetti web | One mediator routes “when A changes, tell B and C” |

**Intent:** Define an object that **encapsulates** how a set of objects **interact**. Mediator promotes **loose coupling** by keeping objects from referring to each other explicitly.

## When to use

- Complex UI dialogs where widgets would otherwise **mutually reference** N² ways.
- Chat rooms, airport control towers (metaphor).

## When to avoid

- Simple two-party coordination—direct calls are clearer.

## Trade-offs

- **Pros:** Centralizes coordination rules; simplifies colleagues.
- **Cons:** Mediator can become a **god object** if not factored.

## Often confused with

- **Observer** — Observer broadcasts events; Mediator **routes** specific interactions.

## Tiny code snapshot

From `MediatorDemo.java` — users never reference each other directly:

```java
void send(String msg) {
    room.broadcast(name, msg);
}

// ChatRoom.broadcast routes to every other User.receive(...)
```

## Files

| File | Role |
|------|------|
| `MediatorDemo.java` | `ChatRoom` mediates users |

## Run

```bash
cd behavioral/mediator
javac MediatorDemo.java
java MediatorDemo
```

## 30-second interview

“Colleagues don’t reference each other—they talk to a mediator that encodes who should react when, shrinking coupling from N² to N.”

## Related

- [[../observer/Observer]] — broadcast vs routed dialog.
