---
tags: [design-patterns, sde2, study-path]
aliases: [Learn order, Study path, 00 Study Sequence]
---

# Study sequence (what matters first)

Companion to [[00-Quick-Revision]] and the per-pattern notes (`*.md` next to each `*Demo.java`). Full map: [[00-Map-of-Content]].

## Why this order

- Start with **composition + messaging** (Strategy, Observer, Command)—they show up in real codebases and interviews constantly.
- Add **wrapping / structure** (Decorator, Adapter, Facade, Proxy, Composite) once you can spot “interface vs tree vs lazy.”
- Leave **heavy indirection** (Visitor, Mediator) and **niche memory patterns** (Flyweight, Bridge) for after you have reps on Tier 1.

## Tier 1 — learn first (do tiny demos)

Rough order within Tier 1 (each builds on “replace conditionals / hide details”):

1. [[behavioral/strategy/Strategy]] — kill giant `if/switch` on policies.
2. [[behavioral/observer/Observer]] — one producer, many listeners.
3. [[creational/factory-method/FactoryMethod]] — `createX()` hook instead of hardcoded `new`.
4. [[creational/builder/Builder]] — many optional fields / fluent `build()`.
5. [[structural/decorator/Decorator]] — stack behavior on same interface.
6. [[structural/adapter/Adapter]] — “dongle” for mismatched APIs.
7. [[structural/facade/Facade]] — one method orchestrates a messy subsystem.
8. [[structural/proxy/Proxy]] — lazy, cache, guard, remote stand-in.
9. [[behavioral/command/Command]] — undo / queue / macro = object with `execute()`.
10. [[behavioral/template-method/TemplateMethod]] — fixed pipeline, subclass hooks.

**Singleton** ([[creational/singleton/Singleton]]): learn **pitfalls + enum idiom**, not as your default DI story. Interview line: “framework singleton scope ≠ GoF Singleton everywhere.”

## Tier 2 — second pass (still common)

- [[structural/composite/Composite]] — trees (UI, folders).
- [[behavioral/state/State]] — real FSM / mode objects.
- [[behavioral/chain-of-responsibility/ChainOfResponsibility]] — filters, support tiers.
- [[creational/abstract-factory/AbstractFactory]] — matched widget/theme **families**.
- [[behavioral/mediator/Mediator]] — dialog controller / chat room style routing.
- [[behavioral/memento/Memento]] — undo stack snapshots without getters soup.

## Tier 3 — skim / interview one-liners

Know **what problem** each solves; code a demo only if curious.

| Pattern | One line if asked | Deep note |
|---------|-------------------|-----------|
| [[structural/bridge/Bridge]] | Two independent axes of change → abstraction holds implementor ref | yes |
| [[structural/flyweight/Flyweight]] | Share immutable “intrinsic” data across zillions of tiny objects | yes |
| [[creational/prototype/Prototype]] | “Copy this template” instead of rebuilding | yes |
| [[behavioral/iterator/Iterator]] | Hide storage; custom `Iterable` / traversal policies | yes |
| [[behavioral/visitor/Visitor]] | Stable AST; add passes via `accept(visitor)` / double dispatch | yes |

## Safe to defer (high-level only)

- **Flyweight** — unless you are in games/editor infra or explicit RAM optimization stories.
- **Bridge** — until you’ve felt the “Cartesian product of subclasses” pain yourself.
- **Visitor** — until AST / compiler-style questions appear; otherwise one sentence + trade-off (“easy new ops, hard new node types”).
- **Prototype** — know clone vs deep copy caveats; full demo optional.
- **Iterator** — in Java interviews, often “I’d use built-in for-each / streams” unless they say custom aggregate.

## Must demo (tiny `javac` file) before claiming depth

Tier 1 list above + **Composite** + **State** + **Chain of Responsibility** if you expect system-design follow-ups.

## Links

- Cram sheet: [[00-Quick-Revision]]
- Vault entry: [[README]]
