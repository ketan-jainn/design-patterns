---
tags: [design-patterns, behavioral, state]
aliases: [State pattern, README]
---

# State

## Jugaad cue

| Signal | Close-your-eyes pick |
|--------|----------------------|
| Object’s **valid actions + behavior** change with an internal **mode** (FSM) | Replace giant `switch` with state objects + transitions |

**Intent:** Allow an object to **alter its behavior** when its **internal state** changes. The object will appear to change its class.

## When to use

- **Explicit** state machines (TCP states, media players, workflow steps).
- Behavior and **valid transitions** are tightly coupled to mode.

## When to avoid

- Simple enums with one function—may not need separate state classes.

## Trade-offs

- **Pros:** Removes giant `switch`; states encapsulate transition rules.
- **Cons:** More classes; wiring transitions must stay consistent.

## Often confused with

- **Strategy** — State objects often know **next** states; Strategy is usually **chosen externally**.

## Tiny code snapshot

From `StateDemo.java` — context delegates to current state object:

```java
class Turnstile {
    private TurnstileState state = new LockedState();

    void coin() {
        state.coin(this);
    }
}
// LockedState.coin → swaps to UnlockedState, etc.
```

## Files

| File | Role |
|------|------|
| `StateDemo.java` | `Turnstile` + state objects |

## Run

```bash
cd behavioral/state
javac StateDemo.java
java StateDemo
```

## 30-second interview

“State replaces mode `switch`es with polymorphism: each state implements `coin()`/`push()` differently and swaps the context’s current state reference.”

## Related

- [[../strategy/Strategy]] — external policy vs internal mode.
