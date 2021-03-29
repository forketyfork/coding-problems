package com.forketyfork.codingproblems;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class Problem2WithoutDivisionTest {

    private static record TestCase(int[] array, int[] expected) {

    }

    public static Stream<TestCase> source() {
        return Stream.of(
                new TestCase(new int[0], new int[0]),
                new TestCase(new int[] {5}, new int[] {1}),
                new TestCase(new int[] {1, 2, 3, 4, 5}, new int[] {120, 60, 40, 30, 24}),
                new TestCase(new int[] {3, 2, 1}, new int[] {2, 3, 6})
        );
    }

    @ParameterizedTest
    @MethodSource("source")
    public void test(TestCase testCase) {
        assertArrayEquals(testCase.expected, new Problem2WithoutDivision().calculate(testCase.array));
    }

}
