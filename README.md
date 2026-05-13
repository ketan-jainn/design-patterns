# Design patterns — interview prep and runnable reference

A compact **GoF-style design patterns** kit: plain Java demos you can compile in a single folder, plus short notes beside the code. Useful for **SDE2-style interviews** and as a **small reference** when you want intent, trade-offs, and working code in one place.

## Intent

- **Who it is for:** engineers revising classic patterns before interviews or when pairing on design discussions.
- **What you get:** each pattern has a **named note** (e.g. `Strategy.md`) with a **tiny code snapshot** and the full runnable `***.java`** files in the **same folder**—no Maven or Gradle, so `javac` / `java` stay the whole toolchain.
- **How to navigate:** treat this **root README** and the `**00-`* hub notes** (links below) as the map. GitHub’s folder view does not auto-render a `README.md` inside every pattern folder the way a wiki might; use the links here to jump to each pattern’s note. If you open the repo as an **Obsidian vault**, wikilinks in [00-Map-of-Content.md](00-Map-of-Content.md) and [00-Study-Sequence.md](00-Study-Sequence.md) work there; everywhere else, the same paths work as normal Markdown links.

## How to use this repo effectively

1. **First pass:** skim **[00-Quick-Revision.md](00-Quick-Revision.md)** — one screen-friendly table: intent, when to use, pitfalls. Good the night before an interview.
2. **Structured study:** follow **[00-Study-Sequence.md](00-Study-Sequence.md)** — Tier 1 patterns and demos first; Tier 3 when you only need a one-liner or a skim.
3. **“Which pattern fits?”** use **[00-Map-of-Content.md](00-Map-of-Content.md)** and the **“What to use when”** table below for decision-style questions.
4. **Per pattern:** open that folder’s `*.md`, read the snapshot and trade-offs, then compile and run the demo in that folder (see **How to run an example**). Prefer running the code over only reading the note when you want depth.

## Quick links

- **[00-Quick-Revision.md](00-Quick-Revision.md)** — one-file cram sheet for all patterns (start here before interviews).
- **[00-Study-Sequence.md](00-Study-Sequence.md)** — what to learn first, what to skim, and safe deferrals.
- **[00-Map-of-Content.md](00-Map-of-Content.md)** — full map, wikilinks (in Obsidian), and “what to use when.”


## Requirements

A **JDK** with `javac` and `java` on your `PATH` (any broadly current LTS is fine for these examples).

## Get a copy

```bash
git clone https://github.com/<you>/<your-repo>.git
cd <your-repo>
```

Replace the URL with your fork or upstream. On GitHub, **this README** is the main entry point—bookmark it or star the repo so others can find the hub notes quickly.

## How to run an example

From the pattern’s folder (example: Strategy). Demo class names differ by folder (e.g. `StrategyDemo`, `ChainDemo` for Chain of Responsibility)—after `javac`, run the `*Demo` class that lives in that folder (`java` takes the **class** name, not the `.java` filename).

```bash
cd behavioral/strategy
javac *.java
java StrategyDemo
```

On Windows PowerShell, `cd` path may need quotes if it contains spaces.

If `javac` fails with `illegal character: '\ufeff'`, the file was saved as UTF-8 **with BOM**—re-save as **UTF-8 without BOM**.

## What to use when (short)


| Situation                                       | Pattern                                                            |
| ----------------------------------------------- | ------------------------------------------------------------------ |
| Swap algorithms at runtime                      | [Strategy](behavioral/strategy/Strategy.md)                        |
| Notify many listeners loosely                   | [Observer](behavioral/observer/Observer.md)                        |
| Encapsulate actions (undo, queue, macros)       | [Command](behavioral/command/Command.md)                           |
| Add behavior by wrapping, not subclassing       | [Decorator](structural/decorator/Decorator.md)                     |
| Make incompatible interfaces work together      | [Adapter](structural/adapter/Adapter.md)                           |
| One simple face on a messy subsystem            | [Facade](structural/facade/Facade.md)                              |
| Control access (lazy, cache, protect)           | [Proxy](structural/proxy/Proxy.md)                                 |
| Tree: treat leaf and branch uniformly           | [Composite](structural/composite/Composite.md)                     |
| Many optional constructor params / fluent setup | [Builder](creational/builder/Builder.md)                           |
| Let subclasses decide which class to create     | [Factory Method](creational/factory-method/FactoryMethod.md)       |
| Families of related products                    | [Abstract Factory](creational/abstract-factory/AbstractFactory.md) |
| Clone instead of expensive construction         | [Prototype](creational/prototype/Prototype.md)                     |
| Exactly one shared instance (use sparingly)     | [Singleton](creational/singleton/Singleton.md)                     |


Browse by category:

- **Creational:** [Singleton](creational/singleton/Singleton.md) · [Factory Method](creational/factory-method/FactoryMethod.md) · [Abstract Factory](creational/abstract-factory/AbstractFactory.md) · [Builder](creational/builder/Builder.md) · [Prototype](creational/prototype/Prototype.md)
- **Structural:** [Adapter](structural/adapter/Adapter.md) · [Decorator](structural/decorator/Decorator.md) · [Facade](structural/facade/Facade.md) · [Proxy](structural/proxy/Proxy.md) · [Composite](structural/composite/Composite.md) · [Bridge](structural/bridge/Bridge.md) · [Flyweight](structural/flyweight/Flyweight.md)
- **Behavioral:** [Strategy](behavioral/strategy/Strategy.md) · [Observer](behavioral/observer/Observer.md) · [Command](behavioral/command/Command.md) · [Template Method](behavioral/template-method/TemplateMethod.md) · [State](behavioral/state/State.md) · [Chain of Responsibility](behavioral/chain-of-responsibility/ChainOfResponsibility.md) · [Iterator](behavioral/iterator/Iterator.md) · [Mediator](behavioral/mediator/Mediator.md) · [Memento](behavioral/memento/Memento.md) · [Visitor](behavioral/visitor/Visitor.md)

