---
tags: [design-patterns, structural, proxy]
aliases: [Proxy pattern, README]
---

# Proxy

## Jugaad cue

| Signal                                                                  | Close-your-eyes pick                                          |
| ----------------------------------------------------------------------- | ------------------------------------------------------------- |
| Real object is **expensive** or **remote** or needs guard before access | Same interface, proxy decides when to forward / cache / block |

**Intent:** Provide a **surrogate** or placeholder for another object to **control access** to it.

## When to use

- **Lazy initialization** of heavy resources.
- **Caching**, logging, access control, remote stubs.

## When to avoid

- Adds latency/complexity when indirection buys nothing.

## Trade-offs

- **Pros:** Transparent optional behavior; can defer cost.
- **Cons:** Stale cache bugs; double network hop for remote proxies.

## Often confused with

- **Decorator** — Proxy usually **controls** access; Decorator **extends** behavior (intent overlap in code shape).

## Tiny code snapshot

From `ProxyDemo.java` — defer creating the real subject until first use:

```java
class ProxyImage implements Image {
    private final String file;
    private RealImage real;

    public void display() {
        if (real == null) {
            real = new RealImage(file);
        }
        real.display();
    }
}
```

## Files

| File | Role |
|------|------|
| `ProxyDemo.java` | `Image` with lazy-loading proxy |

## Run

```bash
cd structural/proxy
javac ProxyDemo.java
java ProxyDemo
```

## 30-second interview

“Proxy stands in for the real subject—classic lazy image: `display()` loads bytes on first use, later calls hit the cached real object.”

## Related

- [[../decorator/Decorator]] — similar wrapping; compare **intent** in interview answers.
