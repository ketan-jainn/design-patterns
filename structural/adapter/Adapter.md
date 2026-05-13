---
tags: [design-patterns, structural, adapter]
aliases: [Adapter pattern, README]
---

# Adapter

## Jugaad cue

| Signal | Close-your-eyes pick |
|--------|----------------------|
| Library returns **A** but your code already speaks **B** | Thin wrapper class—**don’t** rewrite the vendor code |

**Intent:** Convert the interface of a class into another interface clients **expect**.

## When to use

- Integrate **legacy** or third-party code whose API does not match yours.
- Wrap rather than fork upstream.

## When to avoid

- You control both sides—prefer refactoring to a shared interface.

## Trade-offs

- **Pros:** Low risk integration; single responsibility boundary.
- **Cons:** Extra hop; can hide performance or error semantics.

## Often confused with

- **Facade** — Adapter **translates** interfaces; Facade **simplifies** a subsystem.
- **Decorator** — Decorator **adds** behavior with same interface; Adapter **changes** interface.

## Tiny code snapshot

From `AdapterDemo.java` — client sees `JsonParser`, adapter calls legacy XML:

```java
class XmlToJsonAdapter implements JsonParser {
    private final LegacyXmlParser legacy = new LegacyXmlParser();

    public String parseJson(String input) {
        return legacy.parseXml("<root>" + input + "</root>");
    }
}
```

## Files

| File | Role |
|------|------|
| `AdapterDemo.java` | `LegacyXmlParser` adapted to `JsonParser` |

## Run

```bash
cd structural/adapter
javac AdapterDemo.java
java AdapterDemo
```

## 30-second interview

“Adapter wraps an incompatible type so our client talks to `JsonParser` while under the hood we call a legacy XML API—think USB-C to HDMI dongle.”

## Related

- [[../facade/Facade]] — simplify vs translate.
- [[../decorator/Decorator]] — same-shaped interface vs different target interface.
