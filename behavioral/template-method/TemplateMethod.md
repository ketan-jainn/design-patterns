---
tags: [design-patterns, behavioral, template-method]
aliases: [Template Method pattern, README]
---

# Template Method

## Jugaad cue

| Signal | Close-your-eyes pick |
|--------|----------------------|
| Pipeline **order never changes**, only **some steps** differ per subclass | `final` template method calls `abstract`/`protected` hooks |

**Intent:** Define the **skeleton** of an algorithm in an operation, deferring some steps to **subclasses**.

## When to use

- Fixed sequence with **controlled extension points** (`read` → `parse` → `validate`).
- Framework hooks (`onCreate` in Android) style APIs.

## When to avoid

- Prefer **composition** (Strategy) when subclassing becomes brittle.

## Trade-offs

- **Pros:** Duplication removed; invariant steps enforced.
- **Cons:** Inheritance-bound; “fragile base class” risk.

## Often confused with

- **Strategy** — Template Method fixes **structure** in base class; Strategy injects **whole algorithm**.

## Tiny code snapshot

From `TemplateMethodDemo.java` — fixed pipeline, subclass fills `decode`:

```java
abstract class DataImporter {
    final void importFile(String path) {
        byte[] raw = read(path);
        String text = decode(raw);
        validate(text);
        save(text);
    }

    protected abstract String decode(byte[] raw);
}
```

## Files

| File | Role |
|------|------|
| `TemplateMethodDemo.java` | `DataImporter` with hooks |

## Run

```bash
cd behavioral/template-method
javac TemplateMethodDemo.java
java TemplateMethodDemo
```

## 30-second interview

“Template method is `final` orchestration calling `abstract`/`protected` hooks—subclasses customize steps without reordering the pipeline.”

## Related

- [[../strategy/Strategy]] — composition alternative.
