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
                new TestCase(new int[] {0}, new int[] {1}),
                new TestCase(new int[] {5}, new int[] {6}),
                new TestCase(new int[] {1, 1}, new int[] {1, 2}),
                new TestCase(new int[] {1, 2, 3}, new int[] {1, 2, 4}),
                new TestCase(new int[] {9}, new int[] {1, 0}),
                new TestCase(new int[] {9, 9}, new int[] {1, 0, 0}),
                new TestCase(new int[] {9, 9, 9}, new int[] {1, 0, 0, 0})
        );
    }

    @ParameterizedTest
    @MethodSource("source")
    void test(TestCase testCase) {
        assertArrayEquals(testCase.expected, new PlusOne().plusOne(testCase.array));
    }

}