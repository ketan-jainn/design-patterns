---
tags: [design-patterns, creational, builder]
aliases: [Builder pattern, README]
---

# Builder

## Jugaad cue

| Signal | Close-your-eyes pick |
|--------|----------------------|
| Constructor would need **tons of optional params** or boolean flags | Fluent `builder().a().b().build()` + validate once at `build()` |

**Intent:** Separate the **construction** of a complex object from its **representation** so the same process can create different representations.

## When to use

- Many **optional** parameters; want readable fluent setup.
- Invariant multi-step construction (validate at `build()`).

## When to avoid

- Simple POJOs with few fields—constructors are enough.

## Trade-offs

- **Pros:** Readable; immutable objects possible; single `build()` validation choke point.
- **Cons:** More types and boilerplate than telescoping constructors.

## Often confused with

- **Fluent setters** — Builder often returns `this` from steps but also owns **build** semantics.
- **Abstract Factory** — Builder builds **one** complex object stepwise; Abstract Factory creates **families**.

## Tiny code snapshot

From `BuilderDemo.java` — fluent steps + `build()` validation:

```java
HttpRequest r =
    new HttpRequest.Builder()
        .method("POST")
        .url("/api/orders")
        .body("{\"id\":1}")
        .build();
```

## Files

| File | Role |
|------|------|
| `BuilderDemo.java` | `HttpRequest` fluent builder |

## Run

```bash
cd creational/builder
javac BuilderDemo.java
java BuilderDemo
```

## 30-second interview

“Builder hides a complex constructor behind named steps and a final `build()` that can validate invariants—common for HTTP clients, test data, and immutable configs.”

## Related

- [[../prototype/Prototype]] — alternative when cloning is easier than steps.
