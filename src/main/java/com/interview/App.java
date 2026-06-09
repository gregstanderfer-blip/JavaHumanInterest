package com.interview;

/**
 * Entry point for the interview workspace.
 *
 * <p>This is intentionally tiny. Its only job before the interview is to prove the
 * full toolchain works: {@code javac} can compile it, Maven can build/run it, and
 * the JVM on this machine can execute it. During the interview, build your real
 * system in new classes under {@code com.interview} and wire them up from here.
 */
public final class App {

    private App() {
        // utility / entry-point class, not meant to be instantiated
    }

    /**
     * Returns the startup banner. Kept as a pure method so it is trivial to unit test
     * (see {@code AppTest}) without capturing stdout.
     */
    public static String banner() {
        return "JavaHumanInterest is running. Java "
                + System.getProperty("java.version")
                + " on "
                + System.getProperty("os.name");
    }

    public static void main(String[] args) {
        System.out.println(banner());
        System.out.println("Toolchain verified — ready to build.");
    }
}
