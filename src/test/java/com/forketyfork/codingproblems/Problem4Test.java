package com.forketyfork.codingproblems;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Problem4Test {

    private static record TestCase(int[] array, int expected) {

    }

    public static Stream<TestCase> source() {
        return Stream.of(
                new TestCase(new int[0], 1),
                new TestCase(new int[] {1}, 2),
                new TestCase(new int[] {0}, 1),
                new TestCase(new int[] {-1}, 1),
                new TestCase(new int[] {0, 1}, 2),
                new TestCase(new int[] {2, 3}, 1),
                new TestCase(new int[] {-1, -2}, 1),
                new TestCase(new int[] {1, 2, 3}, 4),
                new TestCase(new int[] {3, 4, -1, 1}, 2),
                new TestCase(new int[] {1, 2, 0}, 3),
                new TestCase(new int[] {1, 1, 1}, 2),
                new TestCase(new int[] {-11, 1, 1, 2, 2, 2}, 3),
                new TestCase(new int[] {-1, -2, 0, 1, 2, 0, 2, 1, 18, 129}, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("source")
    void test(TestCase testCase) {
        assertEquals(testCase.expected, new Problem4().calculate(testCase.array));
    }

}
