---
tags: [design-patterns, structural, composite]
aliases: [Composite pattern, README]
---

# Composite

## Jugaad cue

| Signal | Close-your-eyes pick |
|--------|----------------------|
| **Tree**: folder/file, menu/submenu, org chart—same operation on leaf and branch | One `Component` interface + `Composite` holds children |

**Intent:** Compose objects into **tree structures** to represent part-whole hierarchies. Composite lets clients treat individual objects and compositions **uniformly**.

## When to use

- UI widget trees, nested menus, org charts, file systems.
- Clients should not care if node is leaf or branch.

## When to avoid

- Restrictions differ greatly for leaves vs composites—uniform API may force `UnsupportedOperationException` smells.

## Trade-offs

- **Pros:** Recursive algorithms (render, size, search) are simple.
- **Cons:** Type-specific operations leak as `instanceof` or visitor.

## Often confused with

- **Decorator** — both compose; Composite is **tree structure**; Decorator is **linear wrapping**.

## Tiny code snapshot

From `CompositeDemo.java` — leaf and folder both implement `Node`:

```java
class Folder implements Node {
    void add(Node n) { children.add(n); }

    public int sizeBytes() {
        int sum = 0;
        for (Node c : children) {
            sum += c.sizeBytes();
        }
        return sum;
    }
}
```

## Files

| File | Role |
|------|------|
| `CompositeDemo.java` | `FileNode` + `Folder` |

## Run

```bash
cd structural/composite
javac CompositeDemo.java
java CompositeDemo
```

## 30-second interview

“Composite models trees: both files and folders implement `getSize()`—folders delegate to children so the client treats every node polymorphically.”

## Related

- [[../decorator/Decorator]] — different composition story.
