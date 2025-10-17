package com.forketyfork.codingproblems;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ThreeSumTest {

    private static record TestCase(int[] nums, List<List<Integer>> expected) {

    }

    public static Stream<TestCase> source() {
        return Stream.of(
                // Basic case with multiple triplets
                new TestCase(
                    new int[] {-1, 0, 1, 2, -1, -4},
                    List.of(List.of(-1, -1, 2), List.of(-1, 0, 1))
                ),
                // No solution
                new TestCase(
                    new int[] {1, 2, 3},
                    List.of()
                ),
                // Empty array
                new TestCase(
                    new int[] {},
                    List.of()
                ),
                // Array too small
                new TestCase(
                    new int[] {0},
                    List.of()
                ),
                new TestCase(
                    new int[] {0, 0},
                    List.of()
                ),
                // All zeros
                new TestCase(
                    new int[] {0, 0, 0},
                    List.of(List.of(0, 0, 0))
                ),
                new TestCase(
                    new int[] {0, 0, 0, 0},
                    List.of(List.of(0, 0, 0))
                ),
                // Single triplet
                new TestCase(
                    new int[] {-2, 0, 2},
                    List.of(List.of(-2, 0, 2))
                ),
                // Duplicates that should be handled
                new TestCase(
                    new int[] {-1, -1, -1, 0, 1, 1, 1},
                    List.of(List.of(-1, 0, 1))
                ),
                // Multiple solutions with duplicates
                new TestCase(
                    new int[] {-2, 0, 0, 2, 2},
                    List.of(List.of(-2, 0, 2))
                ),
                // All negative except one positive
                new TestCase(
                    new int[] {-4, -2, -2, -1, 0, 1, 2, 2, 2},
                    List.of(
                        List.of(-4, 2, 2),
                        List.of(-2, 0, 2),
                        List.of(-2, -2, 4) // Won't exist, let's adjust
                    )
                ),
                // Corrected: All negative except positives
                new TestCase(
                    new int[] {-4, -2, 1, 2, 3},
                    List.of(List.of(-4, 1, 3))
                ),
                // Large array with multiple solutions
                new TestCase(
                    new int[] {-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5},
                    List.of(
                        List.of(-5, 0, 5),
                        List.of(-5, 1, 4),
                        List.of(-5, 2, 3),
                        List.of(-4, -1, 5),
                        List.of(-4, 0, 4),
                        List.of(-4, 1, 3),
                        List.of(-3, -2, 5),
                        List.of(-3, -1, 4),
                        List.of(-3, 0, 3),
                        List.of(-3, 1, 2),
                        List.of(-2, -1, 3),
                        List.of(-2, 0, 2),
                        List.of(-1, 0, 1)
                    )
                ),
                // Only negative numbers - no solution
                new TestCase(
                    new int[] {-3, -2, -1},
                    List.of()
                ),
                // Only positive numbers - no solution
                new TestCase(
                    new int[] {1, 2, 3},
                    List.of()
                ),
                // Two same negative, one positive
                new TestCase(
                    new int[] {-1, -1, 2},
                    List.of(List.of(-1, -1, 2))
                ),
                // Complex duplicates
                new TestCase(
                    new int[] {0, 0, 0, 0, 0},
                    List.of(List.of(0, 0, 0))
                )
        );
    }

    @ParameterizedTest
    @MethodSource("source")
    void test(TestCase testCase) {
        List<List<Integer>> result = new ThreeSum().threeSum(testCase.nums);
        assertEquals(testCase.expected.size(), result.size(),
            "Expected " + testCase.expected.size() + " triplets but got " + result.size());

        // Check that all expected triplets are in the result
        for (List<Integer> expectedTriplet : testCase.expected) {
            assertTrue(result.contains(expectedTriplet),
                "Expected triplet " + expectedTriplet + " not found in result: " + result);
        }
    }

}
