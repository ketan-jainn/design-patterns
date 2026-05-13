---
tags: [design-patterns, behavioral, chain-of-responsibility]
aliases: [Chain of Responsibility pattern, README]
---

# Chain of Responsibility

## Jugaad cue

| Signal | Close-your-eyes pick |
|--------|----------------------|
| Request may be handled by **L1 or L2 or L3**—sender shouldn’t know which | Linked handlers: try handle, else `next.handle()` |

**Intent:** Avoid coupling the sender of a request to its receiver by giving **more than one object a chance** to handle the request. Chain the receiving objects and **pass the request along** until an object handles it.

## When to use

- Servlet filters, middleware, approval chains, logging pipelines.
- Dynamic handler ordering.

## When to avoid

- Exactly one handler always—call it directly.

## Trade-offs

- **Pros:** Open/Closed for new handlers; sender stays dumb.
- **Cons:** No guarantee of handling; debugging order-sensitive chains.

## Often confused with

- **Decorator** — Decorator always wraps full call chain; CoR **may stop** early.

## Tiny code snapshot

From `ChainDemo.java` — try local handler, else forward:

```java
final void handle(String issue) {
    if (canHandle(issue)) {
        resolve(issue);
    } else if (next != null) {
        next.handle(issue);
    } else {
        System.out.println("escalate: no handler for " + issue);
    }
}
```

## Files

| File | Role |
|------|------|
| `ChainDemo.java` | `SupportHandler` levels |

## Run

```bash
cd behavioral/chain-of-responsibility
javac ChainDemo.java
java ChainDemo
```

## 30-second interview

“Handlers form a linked list: each tries or forwards—like try L1 support, then L2—without the client knowing which concrete class answered.”

## Related

- [[../command/Command]] — encapsulate request object vs pass along chain.
