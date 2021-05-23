package com.forketyfork.codingproblems;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LargestSumOfNonAdjacentTest {

    private static record TestCase(int[] array, int expected) {

    }

    public static Stream<TestCase> source() {
        return Stream.of(

                new TestCase(new int[] {1}, 1),
                new TestCase(new int[] {1, 2}, 2),
                new TestCase(new int[] {2, 4, 6, 2, 5}, 13),
                new TestCase(new int[] {5, 1, 1, 5}, 10),
                new TestCase(new int[] {1, -5, 3, -10, -15}, 4),
                new TestCase(new int[] {1, -5, -3, -10, 1}, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("source")
    public void test(TestCase testCase) {
        assertEquals(testCase.expected, new LargestSumOfNonAdjacent().largestSumOfNonAdjacent(testCase.array));
    }

}
