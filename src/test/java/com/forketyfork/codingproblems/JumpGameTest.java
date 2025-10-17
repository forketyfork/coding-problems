package com.forketyfork.codingproblems;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JumpGameTest {

    private static record TestCase(int[] array, boolean expected) {

    }

    public static Stream<TestCase> source() {
        return Stream.of(
                // Single element (already at end)
                new TestCase(new int[] {0}, true),
                new TestCase(new int[] {1}, true),
                new TestCase(new int[] {5}, true),
                // Two elements
                new TestCase(new int[] {1, 0}, true),
                new TestCase(new int[] {0, 1}, false),
                new TestCase(new int[] {2, 1}, true),
                // Basic reachable cases
                new TestCase(new int[] {1, 2, 3}, true),
                new TestCase(new int[] {2, 3, 1, 1, 4}, true),
                // Basic unreachable case (zero blocks the path)
                new TestCase(new int[] {3, 2, 1, 0, 4}, false),
                new TestCase(new int[] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, 10}, false),
                // Can reach with exact jumps
                new TestCase(new int[] {1, 1, 1, 1, 1}, true),
                new TestCase(new int[] {2, 0, 0}, true),
                new TestCase(new int[] {3, 0, 0, 0}, true),
                // Large jump at start
                new TestCase(new int[] {5, 0, 0, 0, 0, 0}, true),
                new TestCase(new int[] {10, 0, 0, 0, 0}, true),
                // Jump over zeros
                new TestCase(new int[] {2, 0, 6, 9, 8, 4, 5, 0, 8, 9, 1, 2, 9, 6, 8, 8, 0, 6, 3, 1, 2, 2, 1, 2, 6, 5, 3, 1, 2, 2, 6, 4, 2, 4, 3, 0, 0, 0, 3, 8, 2, 4, 0, 1, 2, 0, 1, 4, 6, 5, 8, 0, 7, 9, 3, 4, 6, 6, 5, 8, 9, 3, 4, 3, 7, 0, 4, 9, 0, 9, 8, 4, 3, 0, 7, 7, 1, 9, 1, 9, 4, 9, 0, 1, 9, 5, 7, 7, 1, 5, 8, 2, 8, 2, 6, 8, 2, 2, 7, 5, 1, 7, 9, 6}, true),
                // Cannot jump - zero at start (except single element)
                new TestCase(new int[] {0, 1}, false),
                new TestCase(new int[] {0, 1, 2, 3}, false),
                // Can barely make it
                new TestCase(new int[] {1, 1, 1, 0}, true),
                new TestCase(new int[] {2, 0, 1, 0}, true),
                // Cannot make it - zero blocks
                new TestCase(new int[] {1, 0, 1, 0}, false),
                new TestCase(new int[] {1, 1, 0, 1}, false),
                // Long jump from middle
                new TestCase(new int[] {1, 5, 0, 0, 0, 0}, true),
                // Multiple paths possible
                new TestCase(new int[] {3, 2, 1, 1, 1}, true),
                // Minimum jumps needed
                new TestCase(new int[] {1, 1, 1, 1}, true),
                // Zero at end is fine (already there)
                new TestCase(new int[] {2, 1, 0}, true),
                // Large values
                new TestCase(new int[] {100, 0, 0, 0, 0}, true),
                new TestCase(new int[] {1, 100, 0, 0, 0}, true),
                // Descending non-zero values that work
                new TestCase(new int[] {5, 4, 3, 2, 1}, true),
                // Ascending values
                new TestCase(new int[] {1, 2, 3, 4, 5}, true)
        );
    }

    private final JumpGame jumpGame = new JumpGame();

    @ParameterizedTest
    @MethodSource("source")
    void test(TestCase testCase) {
        assertEquals(testCase.expected, jumpGame.canJump(testCase.array));
    }

}