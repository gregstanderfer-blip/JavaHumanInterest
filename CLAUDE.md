# Project context for the AI agent

This is a timed technical interview workspace. Read this before generating code.

## Hard constraints (do not violate)
- **No external services.** No Redis, Postgres, cloud queues, Docker, or network
  dependencies. Everything runs in-process from a single `java`/`mvn` command.
- **Minimal third-party libraries.** Standard library + collections only. Do NOT add a
  dependency that directly solves the core problem. JUnit 5 (test scope) is the only
  allowed third-party dependency unless I explicitly approve another.
- **Backend only.** No frontend, UI, or web server unless explicitly requested.
- **Java 17** target (see `maven.compiler.release` in `pom.xml`).

## How I want you to work
- Prefer small, targeted changes over one giant generated file. I will be reading and
  explaining your output, so keep classes focused and readable.
- Explain tradeoffs and algorithm/data-structure choices BEFORE writing the implementation.
- Add a brief comment on any non-obvious decision (concurrency, data structure choice, etc.).
- When I change requirements mid-task, adapt the existing design rather than rewriting from
  scratch, and tell me what you changed and why.
- Write or update a JUnit test for new behavior so we can prove it works.

## Project layout
- `src/main/java/com/interview/` — application code (start from `App.java`)
- `src/test/java/com/interview/` — JUnit 5 tests

## Commands
- Compile: `mvn -q compile`
- Test: `mvn -q test`
- Run: `mvn -q compile exec:java`
