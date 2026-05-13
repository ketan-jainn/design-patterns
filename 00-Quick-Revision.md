---
tags: [design-patterns, revision, sde2]
aliases: [Quick Revision]
---

# Quick revision — all patterns

One screen-friendly note: **intent**, **use when**, **pitfall**, then jump to the deep note. No full code here—each deep note has a **tiny code snapshot**; full source is in `*.java` next to it.

| Pattern | Intent (phrase) | Use when | Jugaad blink test |
|---------|-----------------|----------|-------------------|
| Singleton | One shared instance | Global resource, truly single process-wide | “Only one in JVM” — not “I want one bean” |
| Factory Method | Subclass picks concrete type | One product line, extend via subclasses | `createThing()` overridden per platform |
| Abstract Factory | Families of related objects | UI kits, cross-platform families | Win+Win vs Mac+Mac only—never mix |
| Builder | Step-by-step complex object | Many optional fields, readable construction | 6+ optional params / `build()` validates |
| Prototype | Clone template | Cloning cheaper/safer than rebuilding | “Duplicate this preset” |
| Adapter | Wrap to match expected API | Legacy / third-party mismatch | Their API ≠ ours—thin wrapper |
| Decorator | Stack wrappers for features | Add behavior without subclass explosion | Same type, layers: gzip then encrypt |
| Facade | One entry to subsystem | Simplify client + reduce coupling surface | One button runs 5 internal calls |
| Proxy | Stand-in controls access | Lazy load, cache, auth, remote | Heavy/remote subject—defer or guard |
| Composite | Tree treated uniformly | UI trees, org charts, nested menus | Folder + file same `size()` |
| Bridge | Split abstraction from impl | Two dimensions vary independently | `BlueCircle` explosion incoming |
| Flyweight | Share intrinsic state | Huge count of similar lightweight objects | Million cells; shared glyph |
| Strategy | Pluggable algorithms | Runtime policy choice, test in isolation | Giant `switch` on algorithm |
| Observer | Broadcast events | Model → many views, pub/sub style | “Something changed—tell everyone” |
| Command | Request as object | Undo/redo, queue jobs, macros | Need undo queue / macro record |
| Template Method | Fixed skeleton, hooks | Algorithm outline stable, steps vary | Pipeline order fixed, steps subclass |
| State | Behavior follows mode | Object’s rules change with internal state | Turnstile / TCP-style FSM |
| Chain of Responsibility | Pass along until handled | Filters, middleware pipelines | L1→L2→L3 until someone owns it |
| Iterator | Sequential access | Hide collection structure from client | Custom storage, hide internals |
| Mediator | Hub reduces N² links | Dialogs with many cooperating widgets | N widgets would ping each other |
| Memento | Snapshot without breaking caps | Undo stacks, checkpoints | Undo without exposing privates |
| Visitor | Operations over a structure | Many ops on stable class hierarchy | AST + new pass without new node types |

---

## Creational

### Singleton
- **Intent:** Single instance + global access.
- **Use when:** OS-level resource, config holder (still prefer DI in apps).
- **Pitfall:** Testing, hidden deps, concurrency—easy to misuse.
- **Deep:** [[creational/singleton/Singleton]]

### Factory Method
- **Intent:** Creator defers instantiation to subclass.
- **Use when:** Creating objects but type should be extensible.
- **Pitfall:** Subclass proliferation for every variant.
- **Deep:** [[creational/factory-method/FactoryMethod]]

### Abstract Factory
- **Intent:** Create *families* of related products.
- **Use when:** Themes/platforms that must stay consistent within a family.
- **Pitfall:** New product kinds touch many interfaces.
- **Deep:** [[creational/abstract-factory/AbstractFactory]]

### Builder
- **Intent:** Construct complex object step by step.
- **Use when:** Many optional params; readable fluent API.
- **Pitfall:** Boilerplate for simple objects.
- **Deep:** [[creational/builder/Builder]]

### Prototype
- **Intent:** Clone existing instance as starting point.
- **Use when:** Deep copy cheaper than rebuild; registry of templates.
- **Pitfall:** Clone vs reference sharing; deep copy complexity.
- **Deep:** [[creational/prototype/Prototype]]

---

## Structural

### Adapter
- **Intent:** Convert one interface to another clients expect.
- **Use when:** Integrate legacy / external API without changing it.
- **Pitfall:** Thin shims can hide performance cost.
- **Deep:** [[structural/adapter/Adapter]]

### Decorator
- **Intent:** Attach responsibilities dynamically by wrapping.
- **Use when:** Composable features (I/O streams, HTTP middleware).
- **Pitfall:** Order of wrappers matters; debugging stack depth.
- **Deep:** [[structural/decorator/Decorator]]

### Facade
- **Intent:** Simple unified API over complex subsystem.
- **Use when:** Onboarding new clients; bounded contexts.
- **Pitfall:** Facade becomes “god service” if it does everything.
- **Deep:** [[structural/facade/Facade]]

### Proxy
- **Intent:** Surrogate controls access to real subject.
- **Use when:** Lazy init, caching, access control, remote stub.
- **Pitfall:** Extra indirection; stale caches if not invalidated.
- **Deep:** [[structural/proxy/Proxy]]

### Composite
- **Intent:** Treat individual objects and compositions uniformly.
- **Use when:** Trees: UI, documents, org structures.
- **Pitfall:** Type checks leaking (`instanceof` everywhere).
- **Deep:** [[structural/composite/Composite]]

### Bridge
- **Intent:** Decouple abstraction from implementation so both vary.
- **Use when:** Two orthogonal dimensions (e.g. shape × renderer).
- **Pitfall:** More moving parts than inheritance-only design.
- **Deep:** [[structural/bridge/Bridge]]

### Flyweight
- **Intent:** Share intrinsic state across many instances.
- **Use when:** Massive grids of similar objects (text chars, map tiles).
- **Pitfall:** Thread safety for shared flyweights; extrinsic state discipline.
- **Deep:** [[structural/flyweight/Flyweight]]

---

## Behavioral

### Strategy
- **Intent:** Family of algorithms, interchangeable at runtime.
- **Use when:** Policies differ; want to test algorithms independently.
- **Pitfall:** Confused with State (intent vs mode transition rules).
- **Deep:** [[behavioral/strategy/Strategy]]

### Observer
- **Intent:** One-to-many dependency; subject notifies observers.
- **Use when:** UI binding, events, model changes fan out.
- **Pitfall:** Leaks if unsubscribe forgotten; unexpected update order.
- **Deep:** [[behavioral/observer/Observer]]

### Command
- **Intent:** Encapsulate request as object with execute/undo.
- **Use when:** Undo/redo, job queues, transactional steps.
- **Pitfall:** Many small command classes.
- **Deep:** [[behavioral/command/Command]]

### Template Method
- **Intent:** Algorithm skeleton in base; subclasses fill hooks.
- **Use when:** Invariant steps + controlled extension points.
- **Pitfall:** Inheritance-bound; can fight composition preferences.
- **Deep:** [[behavioral/template-method/TemplateMethod]]

### State
- **Intent:** Object delegates behavior to state object; transitions explicit.
- **Use when:** Mode machines with rich behavior per state.
- **Pitfall:** Confused with Strategy (states know about transitions).
- **Deep:** [[behavioral/state/State]]

### Chain of Responsibility
- **Intent:** Handlers in chain; first that can handle stops or passes on.
- **Use when:** Filters, servlet chains, approval workflows.
- **Pitfall:** Hard to guarantee someone handles; ordering sensitivity.
- **Deep:** [[behavioral/chain-of-responsibility/ChainOfResponsibility]]

### Iterator
- **Intent:** Access aggregate without exposing internals.
- **Use when:** Custom collections; hide traversal details.
- **Pitfall:** Concurrent modification if collection mutates during iterate.
- **Deep:** [[behavioral/iterator/Iterator]]

### Mediator
- **Intent:** Objects talk through mediator, not each other N².
- **Use when:** Complex UI dialogs, air-traffic style coordination.
- **Pitfall:** Mediator becomes bloated “mini god.”
- **Deep:** [[behavioral/mediator/Mediator]]

### Memento
- **Intent:** Snapshot state without violating encapsulation.
- **Use when:** Undo stacks, save points, transactional rollback UI.
- **Pitfall:** Memory for large snapshots; caretaker lifecycle.
- **Deep:** [[behavioral/memento/Memento]]

### Visitor
- **Intent:** New operations without changing element classes.
- **Use when:** Stable AST/parse tree; many cross-cutting passes.
- **Pitfall:** Breaks encapsulation; hard to add new *element* types.
- **Deep:** [[behavioral/visitor/Visitor]]
