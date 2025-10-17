package com.forketyfork.codingproblems;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MergeSortedArrayTest {

    private static record TestCase(int[] nums1, int m, int[] nums2, int n, int[] expected) {

    }

    public static Stream<TestCase> source() {
        return Stream.of(
                // Basic merge
                new TestCase(
                    new int[] {1, 2, 3, 0, 0, 0}, 3,
                    new int[] {2, 5, 6}, 3,
                    new int[] {1, 2, 2, 3, 5, 6}
                ),
                // nums2 empty
                new TestCase(
                    new int[] {1}, 1,
                    new int[] {}, 0,
                    new int[] {1}
                ),
                // nums1 empty (only zeros)
                new TestCase(
                    new int[] {0}, 0,
                    new int[] {1}, 1,
                    new int[] {1}
                ),
                // All nums2 elements smaller
                new TestCase(
                    new int[] {4, 5, 6, 0, 0, 0}, 3,
                    new int[] {1, 2, 3}, 3,
                    new int[] {1, 2, 3, 4, 5, 6}
                ),
                // All nums2 elements larger
                new TestCase(
                    new int[] {1, 2, 3, 0, 0, 0}, 3,
                    new int[] {4, 5, 6}, 3,
                    new int[] {1, 2, 3, 4, 5, 6}
                ),
                // Interleaved elements
                new TestCase(
                    new int[] {1, 3, 5, 0, 0, 0}, 3,
                    new int[] {2, 4, 6}, 3,
                    new int[] {1, 2, 3, 4, 5, 6}
                ),
                // Duplicate elements
                new TestCase(
                    new int[] {1, 2, 2, 0, 0, 0}, 3,
                    new int[] {2, 2, 3}, 3,
                    new int[] {1, 2, 2, 2, 2, 3}
                ),
                // Single element in each
                new TestCase(
                    new int[] {2, 0}, 1,
                    new int[] {1}, 1,
                    new int[] {1, 2}
                ),
                // Single element - nums2 larger
                new TestCase(
                    new int[] {1, 0}, 1,
                    new int[] {2}, 1,
                    new int[] {1, 2}
                ),
                // Negative numbers
                new TestCase(
                    new int[] {-3, -1, 0, 0, 0}, 2,
                    new int[] {-2, 0, 1}, 3,
                    new int[] {-3, -2, -1, 0, 1}
                ),
                // All same values
                new TestCase(
                    new int[] {1, 1, 1, 0, 0}, 3,
                    new int[] {1, 1}, 2,
                    new int[] {1, 1, 1, 1, 1}
                ),
                // Zero values
                new TestCase(
                    new int[] {0, 0, 0, 0, 0}, 2,
                    new int[] {0, 0, 0}, 3,
                    new int[] {0, 0, 0, 0, 0}
                ),
                // Large difference in sizes
                new TestCase(
                    new int[] {1, 0, 0, 0, 0, 0}, 1,
                    new int[] {2, 3, 4, 5, 6}, 5,
                    new int[] {1, 2, 3, 4, 5, 6}
                ),
                new TestCase(
                    new int[] {1, 2, 3, 4, 5, 0}, 5,
                    new int[] {6}, 1,
                    new int[] {1, 2, 3, 4, 5, 6}
                ),
                // Mixed positive and negative
                new TestCase(
                    new int[] {-1, 0, 1, 0, 0, 0}, 3,
                    new int[] {-2, 2, 3}, 3,
                    new int[] {-2, -1, 0, 1, 2, 3}
                )
        );
    }

    @ParameterizedTest
    @MethodSource("source")
    void test(TestCase testCase) {
        new MergeSortedArray().merge(testCase.nums1, testCase.m, testCase.nums2, testCase.n);
        assertArrayEquals(testCase.expected, testCase.nums1,
            "Arrays should be properly merged and sorted");
    }

}
