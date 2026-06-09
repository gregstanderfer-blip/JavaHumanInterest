package com.interview;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Smoke tests. These exist to prove the test runner (JUnit 5 via Surefire) is wired
 * up correctly, so `mvn test` is a meaningful "the system works" signal during setup.
 */
class AppTest {

    @Test
    @DisplayName("banner is produced and mentions the project")
    void bannerIsProduced() {
        String banner = App.banner();
        assertNotNull(banner, "banner should never be null");
        assertTrue(banner.contains("JavaHumanInterest"),
                "banner should name the project, was: " + banner);
    }

    @Test
    @DisplayName("sanity check: the test harness itself runs")
    void harnessRuns() {
        assertTrue(1 + 1 == 2);
    }
}
