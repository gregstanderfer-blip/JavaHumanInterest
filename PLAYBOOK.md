# Interview playbook — using AI to build the backend

Graded on: understand the problem → direct the AI → catch wrong/incomplete output →
explain what was built. This sequence hits all four.

## 1. First ~3-5 min: no AI. Understand the problem.
Restate it back to the interviewer in your own words:
- Inputs / outputs / the core operation
- Constraints (in-process, no external services, minimal libs, Java 17)
- Edge cases out loud: empty input, concurrency, ordering, ties, capacity limits

## 2. Design WITH Claude before any code.
First prompt is a discussion, not "build X":
> Here's the problem: [paste]. Constraints: in-process only, no external services,
> minimal libs, Java 17. Don't write code yet. Propose 2-3 approaches, the key data
> structures, and the tradeoffs. Where are the tricky parts (concurrency, complexity)?

Pick an approach and tell the interviewer WHY. (This is the "tradeoffs out loud" signal.)

## 3. Lock the shape first.
Ask for the domain model and method signatures / interfaces only — no implementations.
Read them, check the API against the requirements, adjust. Now you own a skeleton.

## 4. Build in small vertical slices, test each.
One component per prompt, with a test:
> Implement only put/get with TTL expiry in Store.java. Add JUnit tests for expiry and
> overwrite. Keep it to this class.

After each slice: `mvn -q test`. Green test = fastest "it works" demo. Small prompts keep
you ahead of the code.

## 5. Read everything before moving on.
If you don't fully follow the output, stop and ask:
> Explain why you used X here and what breaks if the input is empty.

They WILL ask you to explain it. Catching a wrong/incomplete bit here is top-value signal.

## 6. Expect a requirements change. Adapt, don't rewrite.
Say what you'll change and why first, then modify the existing design:
> Add thread-safety to Store without changing its public API; explain the locking choice.

Re-run tests.

## Throughout
- Reference `CLAUDE.md` — it already enforces the constraints.
- Keep `mvn -q test` green so you can always demo a working state.
- Narrate what you're doing and why.
- Biggest trap: letting the AI sprint ahead → code you can't explain. Steps 1 and 5 prevent it.

## Quick commands
```bash
mvn -q test                 # run tests
mvn -q compile exec:java     # run main
mvn -q -Dtest=FooTest test   # single test class
```
