package com.forketyfork.codingproblems;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TwoSumTest {

    private static record TestCase(int[] nums, int target, int[] expected) {

    }

    public static Stream<TestCase> source() {
        return Stream.of(
                // Basic cases
                new TestCase(new int[] {2, 7, 11, 15}, 9, new int[] {0, 1}),
                new TestCase(new int[] {3, 2, 4}, 6, new int[] {1, 2}),
                new TestCase(new int[] {3, 3}, 6, new int[] {0, 1}),
                // Two elements only
                new TestCase(new int[] {1, 2}, 3, new int[] {0, 1}),
                new TestCase(new int[] {0, 0}, 0, new int[] {0, 1}),
                // Negative numbers
                new TestCase(new int[] {-1, -2, -3, -4, -5}, -8, new int[] {2, 4}),
                new TestCase(new int[] {-3, 4, 3, 90}, 0, new int[] {0, 2}),
                // Mix of positive and negative
                new TestCase(new int[] {-1, 0, 1, 2}, 1, new int[] {0, 3}),
                new TestCase(new int[] {5, -5, 10}, 5, new int[] {0, 1}),
                // Large array
                new TestCase(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 19, new int[] {8, 9}),
                // Target at beginning
                new TestCase(new int[] {10, 5, 2, 3}, 15, new int[] {0, 1}),
                // Target at end
                new TestCase(new int[] {1, 2, 3, 10, 5}, 15, new int[] {3, 4}),
                // Same number used twice (different indices)
                new TestCase(new int[] {5, 5}, 10, new int[] {0, 1}),
                new TestCase(new int[] {1, 5, 5, 11}, 10, new int[] {1, 2}),
                // Zero in array
                new TestCase(new int[] {0, 4, 3, 0}, 0, new int[] {0, 3}),
                new TestCase(new int[] {-1, 0, 1}, 0, new int[] {0, 2}),
                // Large numbers
                new TestCase(new int[] {1000000, 2000000, 3000000}, 5000000, new int[] {1, 2})
        );
    }

    @ParameterizedTest
    @MethodSource("source")
    void test(TestCase testCase) {
        int[] result = new TwoSum().twoSum(testCase.nums, testCase.target);
        assertArrayEquals(testCase.expected, result,
            "Expected indices " + testCase.expected[0] + " and " + testCase.expected[1] +
            " for target " + testCase.target);
    }

}
