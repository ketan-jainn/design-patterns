---
tags: [design-patterns, behavioral, iterator]
aliases: [Iterator pattern, README]
---

# Iterator

## Jugaad cue

| Signal | Close-your-eyes pick |
|--------|----------------------|
| You want `for (x : mine)` but **hide** array vs list vs weird storage | Implement `Iterable` / custom `Iterator` |

**Intent:** Provide a way to access the elements of an **aggregate object sequentially** without exposing its underlying representation.

## When to use

- Custom collections, paging cursors, tree traversals where **multiple traversal policies** exist.

## When to avoid

- Language built-ins (`for (T x : c)`) suffice.

## Trade-offs

- **Pros:** Decouples traversal algorithm from collection.
- **Cons:** Extra types; concurrent modification must be documented.

## Often confused with

- **Visitor** — Iterator walks elements; Visitor runs **operations** over them.

## Tiny code snapshot

From `IteratorDemo.java` — hide array storage behind `Iterator`:

```java
public Iterator<String> iterator() {
    return new Iterator<String>() {
        private int i;

        public boolean hasNext() {
            return i < size;
        }

        public String next() {
            return books[i++];
        }
    };
}
```

## Files

| File | Role |
|------|------|
| `IteratorDemo.java` | `BookShelf` + inner iterator |

## Run

```bash
cd behavioral/iterator
javac IteratorDemo.java
java IteratorDemo
```

## 30-second interview

“Iterator hides whether storage is array or linked list—client uses `hasNext`/`next` without knowing internal layout.”

## Related

- [[../visitor/Visitor]] — traversal + operation.
