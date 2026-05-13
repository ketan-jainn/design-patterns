---
tags: [design-patterns, structural, flyweight]
aliases: [Flyweight pattern, README]
---

# Flyweight

## Jugaad cue

| Signal | Close-your-eyes pick |
|--------|----------------------|
| **Millions** of tiny objects differ only by position/context, intrinsic part repeats | Pool shared immutable flyweights; pass extrinsic state in |

**Intent:** Use **sharing** to support large numbers of fine-grained objects **efficiently**.

## When to use

- Many near-identical objects where **intrinsic state** can be shared (glyphs, map tiles, particles).
- Extrinsic state passed in at use time.

## When to avoid

- Few objects or uniqueness dominates—sharing adds complexity without RAM wins.

## Trade-offs

- **Pros:** Lower memory footprint.
- **Cons:** Thread safety for shared flyweights; harder API (must pass context).

## Often confused with

- **Singleton** — Flyweight **many** shared instances keyed by state; Singleton **one** instance.

## Tiny code snapshot

From `FlyweightDemo.java` — pool and reuse by key; position passed in:

```java
class GlyphFactory {
    private final Map<Character, GlyphFlyweight> pool = new HashMap<>();

    GlyphFlyweight get(char c) {
        return pool.computeIfAbsent(c, GlyphFlyweight::new);
    }
}
// drawAt(x,y) passes extrinsic coordinates into shared flyweight
```

## Files

| File | Role |
|------|------|
| `FlyweightDemo.java` | `Glyph` factory reuses flyweights |

## Run

```bash
cd structural/flyweight
javac FlyweightDemo.java
java FlyweightDemo
```

## 30-second interview

“Flyweight stores immutable character/font data once per unique combo; render position is extrinsic—think text editor storing one shared ‘A’ object per font/size.”

## Related

- [[../composite/Composite]] — trees of many nodes; Flyweight shrinks node payload.
