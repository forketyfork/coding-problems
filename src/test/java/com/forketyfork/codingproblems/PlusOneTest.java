package com.forketyfork.codingproblems;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class PlusOneTest {

    private static record TestCase(int[] array, int[] expected) {

    }

    public static Stream<TestCase> source() {
        return Stream.of(
                // Single digit cases
                new TestCase(new int[] {0}, new int[] {1}),
                new TestCase(new int[] {5}, new int[] {6}),
                new TestCase(new int[] {8}, new int[] {9}),
                // Single digit with carry
                new TestCase(new int[] {9}, new int[] {1, 0}),
                // Multiple digits without carry
                new TestCase(new int[] {1, 1}, new int[] {1, 2}),
                new TestCase(new int[] {1, 2, 3}, new int[] {1, 2, 4}),
                new TestCase(new int[] {4, 3, 2, 1}, new int[] {4, 3, 2, 2}),
                // Multiple digits with carry in last position only
                new TestCase(new int[] {1, 2, 9}, new int[] {1, 3, 0}),
                new TestCase(new int[] {2, 9, 9}, new int[] {3, 0, 0}),
                // Multiple digits with partial carry
                new TestCase(new int[] {1, 9, 9}, new int[] {2, 0, 0}),
                new TestCase(new int[] {9, 8, 9}, new int[] {9, 9, 0}),
                // All nines - full carry with array extension
                new TestCase(new int[] {9, 9}, new int[] {1, 0, 0}),
                new TestCase(new int[] {9, 9, 9}, new int[] {1, 0, 0, 0}),
                new TestCase(new int[] {9, 9, 9, 9}, new int[] {1, 0, 0, 0, 0}),
                // Large numbers
                new TestCase(new int[] {9, 9, 9, 9, 9, 9, 9}, new int[] {1, 0, 0, 0, 0, 0, 0, 0}),
                new TestCase(new int[] {1, 2, 3, 4, 5, 6, 7, 8}, new int[] {1, 2, 3, 4, 5, 6, 7, 9}),
                // Edge case with leading non-nine followed by nines
                new TestCase(new int[] {1, 9, 9, 9}, new int[] {2, 0, 0, 0}),
                new TestCase(new int[] {8, 9, 9, 9}, new int[] {9, 0, 0, 0})
        );
    }

    @ParameterizedTest
    @MethodSource("source")
    void test(TestCase testCase) {
        assertArrayEquals(testCase.expected, new PlusOne().plusOne(testCase.array));
    }

}