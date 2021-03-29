package com.forketyfork.codingproblems;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TwoSumExistsTest {

    private static record TestCase(int target, int[] array, boolean expected) {

    }

    public static Stream<TestCase> source() {
        return Stream.of(
                new TestCase(5, new int[0], false),
                new TestCase(5, new int[] {5}, false),
                new TestCase(3, new int[] {1, 4, 2}, true),
                new TestCase(3, new int[] {1, 2}, true),
                new TestCase(3, new int[] {1, 4, 5, 8, 12}, false),
                new TestCase(13, new int[] {1, 4, 5, 8, 12}, true),
                new TestCase(12, new int[] {1, 4, 5, 8, 12}, true)
        );
    }

    @ParameterizedTest
    @MethodSource("source")
    public void test(TestCase testCase) {
        assertEquals(testCase.expected, new TwoSumExists().check(testCase.target, testCase.array));
    }

}
