package com.forketyfork.codingproblems;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberOfWaysToReorderArrayTest {

    private record TestCase(int[] array, int expected) {

    }

    public static Stream<TestCase> source() {
        return Stream.of(
                new TestCase(new int[] {2, 1, 3}, 1),
                new TestCase(new int[] {3, 4, 5, 1, 2}, 5),
                new TestCase(new int[] {1, 2, 3}, 0),
                new TestCase(new int[] {3, 1, 2, 5, 4, 6}, 19),
                new TestCase(new int[] {9, 4, 2, 1, 3, 6, 5, 7, 8, 14, 11, 10, 12, 13, 16, 15, 17, 18}, 216212978),
                new TestCase(new int[] {
                        30, 11, 46, 3, 29, 22, 37, 32, 13, 49, 48, 16, 40, 8, 24, 44, 9, 39, 25, 21, 41, 26, 43, 19, 47,
                        7, 10, 31, 45, 4, 35, 14, 20, 23, 15, 17, 38, 2, 6, 18, 5, 33, 27, 36, 42, 28, 12, 34, 1
                }, 137401437)
        );
    }

    private final NumberOfWaysToReorderArray numberOfWaysToReorderArray = new NumberOfWaysToReorderArray();

    @ParameterizedTest
    @MethodSource("source")
    void test(TestCase testCase) {
        assertEquals(testCase.expected, numberOfWaysToReorderArray.numOfWays(testCase.array));
    }

}