---
tags: [design-patterns, behavioral, observer]
aliases: [Observer pattern, README]
---

# Observer

## Jugaad cue

| Signal | Close-your-eyes pick |
|--------|----------------------|
| “**Something changed**—whoever cares should react” (unknown how many listeners) | Subject keeps subscriber list + `notify()` |

**Intent:** Define a **one-to-many** dependency between objects so that when one object changes state, all its dependents are **notified and updated** automatically.

## When to use

- Model → multiple views, domain events, reactive UI.
- Decouple producers from unknown number of consumers.

## When to avoid

- Hot paths with massive fan-out—consider batching or async buses.

## Trade-offs

- **Pros:** Loose coupling; dynamic subscription.
- **Cons:** Order of delivery; memory leaks if unsubscribe forgotten; cascading updates.

## Often confused with

- **Pub/Sub** — Observer is usually in-process direct list; pub/sub often adds **topic** and **async** middleware.

## Tiny code snapshot

From `ObserverDemo.java` — publish fans out to all subscribers:

```java
void publish(String headline) {
    latest = headline;
    for (Subscriber s : subs) {
        s.onNews(latest);
    }
}
```

## Files

| File | Role |
|------|------|
| `ObserverDemo.java` | `NewsAgency` + `Subscriber` |

## Run

```bash
cd behavioral/observer
javac ObserverDemo.java
java ObserverDemo
```

## 30-second interview

“Subject keeps a list of observers; on `notify()` each gets `update()`—JDK `PropertyChangeListener` and RxJava are modern spins on the same idea.”

## Related

- [[../mediator/Mediator]] — central hub vs broadcast list.
