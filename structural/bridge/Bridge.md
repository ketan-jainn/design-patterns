---
tags: [design-patterns, structural, bridge]
aliases: [Bridge pattern, README]
---

# Bridge

## Jugaad cue

| Signal | Close-your-eyes pick |
|--------|----------------------|
| You’re about to name classes `BlueCircle`, `RedSquare`, … (**two axes** of change) | Split: abstraction holds reference to **implementor** interface |

**Intent:** **Decouple** an abstraction from its implementation so that the two can vary **independently**.

## When to use

- Two orthogonal dimensions (e.g. **shape** × **renderer**, **remote** × **transport**).
- Avoid permanent inheritance matrix `BlueCircle`, `RedSquare`, …

## When to avoid

- Single dimension of variation—plain inheritance is simpler.

## Trade-offs

- **Pros:** Replace implementation at runtime; smaller class fan-out.
- **Cons:** Extra indirection; naming can feel abstract.

## Often confused with

- **Adapter** — Bridge is **planned** separation up front; Adapter is often **retrofit** integration.

## Tiny code snapshot

From `BridgeDemo.java` — abstraction holds an implementor:

```java
abstract class Shape {
    protected final Renderer renderer;
    abstract void draw();
}

class Circle extends Shape {
    void draw() {
        renderer.renderCircle(radius);
    }
}
```

## Files

| File | Role |
|------|------|
| `BridgeDemo.java` | `Shape` holds `Renderer` implementor |

## Run

```bash
cd structural/bridge
javac BridgeDemo.java
java BridgeDemo
```

## 30-second interview

“Bridge pulls the implementation reference out of the abstraction—`Circle` delegates drawing to a `Renderer` so we add new shapes without touching raster vs vector code paths.”

## Related

- [[../adapter/Adapter]] — planned vs retrofit split.
