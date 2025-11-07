package org.techishthoughts.workflows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Simple test class to verify the workflow setup
 */
@DisplayName("Workflow Tests")
class WorkflowTest {

    @Test
    @DisplayName("Should pass basic test")
    void shouldPassBasicTest() {
        assertTrue(true, "Basic test should always pass");
    }

    @Test
    @DisplayName("Should handle string operations")
    void shouldHandleStringOperations() {
        String testString = "Hello, Workflows!";
        assertNotNull(testString);
        assertEquals(17, testString.length());
        assertTrue(testString.contains("Workflows"));
    }

    @Test
    @DisplayName("Should perform math operations")
    void shouldPerformMathOperations() {
        int a = 5;
        int b = 3;
        assertEquals(8, a + b);
        assertEquals(2, a - b);
        assertEquals(15, a * b);
    }
}
