package com.forketyfork.codingproblems;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TrappingRainWaterTest {

    private static record TestCase(int[] height, int expected) {

    }

    public static Stream<TestCase> source() {
        return Stream.of(
                // Classic example
                new TestCase(new int[] {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}, 6),
                // Another example
                new TestCase(new int[] {4, 2, 0, 3, 2, 5}, 9),
                // Empty array
                new TestCase(new int[] {}, 0),
                // Single element
                new TestCase(new int[] {1}, 0),
                // Two elements
                new TestCase(new int[] {1, 2}, 0),
                new TestCase(new int[] {2, 1}, 0),
                // Three elements - can trap water
                new TestCase(new int[] {3, 0, 3}, 3),
                new TestCase(new int[] {2, 1, 2}, 1),
                // Three elements - cannot trap water
                new TestCase(new int[] {1, 2, 3}, 0),
                new TestCase(new int[] {3, 2, 1}, 0),
                // All zeros
                new TestCase(new int[] {0, 0, 0, 0}, 0),
                // All same height
                new TestCase(new int[] {5, 5, 5, 5}, 0),
                // Single valley
                new TestCase(new int[] {5, 0, 5}, 5),
                new TestCase(new int[] {5, 1, 5}, 4),
                new TestCase(new int[] {5, 2, 5}, 3),
                // Deep valley
                new TestCase(new int[] {5, 0, 0, 0, 5}, 15),
                // Multiple valleys
                new TestCase(new int[] {3, 0, 2, 0, 4}, 7),
                // Ascending then descending
                new TestCase(new int[] {1, 2, 3, 4, 3, 2, 1}, 0),
                // Valley at start
                new TestCase(new int[] {0, 1, 0, 2}, 1),
                // Valley at end
                new TestCase(new int[] {2, 0, 1, 0}, 1),
                // Step pattern up
                new TestCase(new int[] {1, 2, 3, 4, 5}, 0),
                // Step pattern down
                new TestCase(new int[] {5, 4, 3, 2, 1}, 0),
                // Complex pattern
                new TestCase(new int[] {5, 2, 1, 2, 1, 5}, 14),
                // Two peaks with valley
                new TestCase(new int[] {4, 0, 4}, 4),
                new TestCase(new int[] {3, 1, 2, 1, 3}, 4),
                // Uneven peaks
                new TestCase(new int[] {2, 0, 0, 0, 5}, 8),
                new TestCase(new int[] {5, 0, 0, 0, 2}, 8),
                // Multiple small valleys
                new TestCase(new int[] {1, 0, 1, 0, 1, 0, 1}, 3),
                // Large array with complex pattern
                new TestCase(new int[] {6, 4, 2, 0, 3, 2, 0, 3, 1, 4, 5, 3, 2, 7, 5, 3, 0, 2}, 46),
                // Plateau in middle
                new TestCase(new int[] {3, 0, 2, 2, 0, 3}, 9),
                // No water at boundaries
                new TestCase(new int[] {0, 1, 2, 1, 0}, 0),
                // Single dip between high walls
                new TestCase(new int[] {10, 5, 10}, 5)
        );
    }

    @ParameterizedTest
    @MethodSource("source")
    void test(TestCase testCase) {
        assertEquals(testCase.expected, new TrappingRainWater().trap(testCase.height),
            "Amount of trapped water should match expected value for height array");
    }

}
