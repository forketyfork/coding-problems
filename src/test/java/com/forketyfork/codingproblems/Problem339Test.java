package com.forketyfork.codingproblems;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Problem339Test {

    private static record TestCase(int[] array, int k, boolean expected) {

    }

    @ParameterizedTest
    @MethodSource("source")
    public void test(TestCase testCase) {
        assertEquals(testCase.expected, new Problem339().sum3(testCase.array, testCase.k));
    }

    public static Stream<TestCase> source() {
        return Stream.of(
                new TestCase(new int[] {20, 303, 3, 4, 25}, 49, true),
                new TestCase(new int[] {5, 5, 5}, 15, true),
                new TestCase(new int[] {5, 5, 4}, 15, false),
                new TestCase(new int[] {}, 10, false),
                new TestCase(new int[] {10}, 10, false),
                new TestCase(new int[] {1, 9}, 10, false)
        );
    }

}
