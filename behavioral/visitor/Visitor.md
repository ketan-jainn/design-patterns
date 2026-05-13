---
tags: [design-patterns, behavioral, visitor]
aliases: [Visitor pattern, README]
---

# Visitor

## Jugaad cue

| Signal | Close-your-eyes pick |
|--------|----------------------|
| **AST / IR stable**, but you keep adding **new passes** (print, lint, codegen) | `accept(Visitor)` double dispatch—new visitor class per pass |

**Intent:** Represent an **operation** to be performed on the elements of an object structure. Visitor lets you define a **new operation** without changing the classes of the elements on which it operates.

## When to use

- **Stable element hierarchy** (AST, IR) with many **cross-cutting passes** (pretty-print, lint, codegen).
- Double dispatch is acceptable in your language.

## When to avoid

- Element types churn frequently—every new type touches all visitors.

## Trade-offs

- **Pros:** Groups related operations per visitor class; keeps element classes small.
- **Cons:** Breaks encapsulation; hard to add new *element* types.

## Often confused with

- **Iterator** — Iterator walks; Visitor defines **what to do** at each node.

## Tiny code snapshot

From `VisitorDemo.java` — `accept` dispatches to the right `visit*` overload:

```java
interface Shape {
    void accept(Visitor v);
}

class Dot implements Shape {
    public void accept(Visitor v) {
        v.visitDot(this);
    }
}
```

## Files

| File | Role |
|------|------|
| `VisitorDemo.java` | `accept(Visitor)` on nodes |

## Run

```bash
cd behavioral/visitor
javac VisitorDemo.java
java VisitorDemo
```

## 30-second interview

“Visitor adds `accept(v)` on each node type so the compiler picks the right `visitFoo` overload—trade-off: easy new operations, painful new node types.”

## Related

- [[../iterator/Iterator]] — walk vs operate.
