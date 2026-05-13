---
tags: [design-patterns, behavioral, command]
aliases: [Command pattern, README]
---

# Command

## Jugaad cue

| Signal | Close-your-eyes pick |
|--------|----------------------|
| Need **undo**, **macro**, **queue**, or **log** “what was done” as first-class thing | Wrap action in object with `execute()` (and maybe `undo()`) |

**Intent:** Encapsulate a **request** as an object, thereby letting you **parameterize** clients with different requests, **queue** or **log** requests, and support **undoable** operations.

## When to use

- **Undo/redo**, macro recording, job queues, transactional scripts.
- Decouple UI actions from execution.

## When to avoid

- Trivial one-off calls with no history/queue needs.

## Trade-offs

- **Pros:** Extensible command set; composable macros.
- **Cons:** Many small classes; state for undo must be captured carefully.

## Often confused with

- **Strategy** — both encapsulate behavior; Command models **requests/time**; Strategy models **algorithms**.

## Tiny code snapshot

From `CommandDemo.java` — invoker works with `Command`, not raw `Light` API:

```java
class Remote {
    void press(Command cmd) {
        cmd.execute();
    }
}

remote.press(new LightOnCommand(light));
```

## Files

| File | Role |
|------|------|
| `CommandDemo.java` | `Command` + `Remote` invoker |

## Run

```bash
cd behavioral/command
javac CommandDemo.java
java CommandDemo
```

## 30-second interview

“Command wraps `execute()` (and optionally `undo()`) so the invoker can queue, log, or replay operations—think GUI actions or thread-pool tasks.”

## Related

- [[../memento/Memento]] — snapshot state for undo beyond command-local fields.
