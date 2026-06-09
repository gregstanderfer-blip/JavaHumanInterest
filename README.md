# JavaHumanInterest

Backend interview workspace. Maven + Java 17 + JUnit 5. No external services, minimal
third-party libraries, backend only.

## Pre-interview checklist

Run these from this folder, top to bottom. If all four succeed, you are set up.

```bash
# 1. Confirm a JDK (not just a JRE) is installed. Needs javac, version >= 17.
java -version
javac -version

# 2. Confirm Maven is installed.
mvn -version

# 3. Build + run the tests (proves JUnit/Surefire work).
mvn -q test

# 4. Run the app (proves the toolchain runs end to end).
mvn -q compile exec:java
```

Expected output from step 4:

```
JavaHumanInterest is running. Java 17.x.x on Mac OS X
Toolchain verified — ready to build.
```

## If something fails

- **`javac: command not found`** — you have a JRE but no JDK. Install a JDK 17+
  (e.g. `brew install openjdk@17`) and follow brew's instructions to put it on PATH.
- **`mvn: command not found`** — install Maven (`brew install maven`).
- **Compiler version error** — your JDK major version differs from the project target.
  Open `pom.xml` and set `<maven.compiler.release>` to match your `java -version`
  (e.g. `21`), then re-run.

## Run options during the interview

```bash
mvn -q compile exec:java        # run main without packaging
mvn -q package                  # build target/java-human-interest.jar
java -jar target/java-human-interest.jar
mvn -q test                     # run all JUnit tests
mvn -q -Dtest=AppTest test      # run a single test class
```

## Layout

```
pom.xml                                  Maven build (Java 17, JUnit 5, exec + jar plugins)
CLAUDE.md                                constraints/context for the AI agent
src/main/java/com/interview/App.java     entry point (replace/extend during interview)
src/test/java/com/interview/AppTest.java JUnit 5 smoke tests
```

## During the interview

- Build your real system in new classes under `src/main/java/com/interview/`.
- Keep `mvn -q test` green — it is your fastest "it works" demonstration.
- `CLAUDE.md` already primes the agent on the constraints; reference it in prompts.
