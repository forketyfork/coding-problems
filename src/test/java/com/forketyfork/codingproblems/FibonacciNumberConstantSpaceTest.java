package com.forketyfork.codingproblems;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FibonacciNumberConstantSpaceTest {

    private static record TestCase(int source, int expected) {

    }

    @ParameterizedTest
    @MethodSource("source")
    void test(TestCase testCase) {
        assertEquals(testCase.expected, new FibonacciNumberConstantSpace().fib(testCase.source));
    }

    public static Stream<TestCase> source() {
        return Stream.of(
                new TestCase(0, 0),
                new TestCase(1, 1),
                new TestCase(2, 1),
                new TestCase(3, 2),
                new TestCase(4, 3),
                new TestCase(5, 5),
                new TestCase(6, 8),
                new TestCase(7, 13),
                new TestCase(8, 21),
                new TestCase(9, 34)
        );
    }

}
