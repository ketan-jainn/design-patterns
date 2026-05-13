---
tags: [design-patterns, structural, facade]
aliases: [Facade pattern, README]
---

# Facade

## Jugaad cue

| Signal | Close-your-eyes pick |
|--------|----------------------|
| New dev needs **one** call to “do the thing” across 5 internal services | Facade method orchestrates subsystem calls |

**Intent:** Provide a **unified interface** to a set of interfaces in a subsystem.

## When to use

- Onboard new clients to a messy subsystem with **one** entry point.
- Define an **application boundary** (bounded context API).

## When to avoid

- Facade becomes a **kitchen-sink** service that knows everything—split by use cases.

## Trade-offs

- **Pros:** Hides complexity; reduces coupling to many types.
- **Cons:** Wrong abstraction can hide useful power knobs.

## Often confused with

- **Adapter** — Facade **simplifies** many types; Adapter **matches** one foreign interface.

## Tiny code snapshot

From `FacadeDemo.java` — one method runs the subsystem sequence:

```java
class ComputerFacade {
    void start() {
        cpu.freeze();
        mem.load(0, disk.read(0, 8));
        cpu.jump(0);
        cpu.execute();
    }
}
```

## Files

| File | Role |
|------|------|
| `FacadeDemo.java` | `Computer` starts CPU/RAM/Disk |

## Run

```bash
cd structural/facade
javac FacadeDemo.java
java FacadeDemo
```

## 30-second interview

“Facade is a thin coordinator: `computer.start()` internally sequences CPU, memory, and disk without the client touching five different APIs.”

## Related

- [[../adapter/Adapter]] — integration vs simplification.
