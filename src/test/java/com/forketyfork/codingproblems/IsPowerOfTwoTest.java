package com.forketyfork.codingproblems;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IsPowerOfTwoTest {

    private static record TestCase(int n, boolean expected) {

    }

    public static Stream<TestCase> source() {
        return Stream.of(
                new TestCase(1, true),
                new TestCase(0, false),
                new TestCase(-1, false),
                new TestCase(Integer.MIN_VALUE, false),
                new TestCase(Integer.MAX_VALUE, false),
                new TestCase(2, true),
                new TestCase(3, false),
                new TestCase(4, true),
                new TestCase(5, false),
                new TestCase(16, true)
        );
    }

    private final IsPowerOfTwo isPowerOfTwo = new IsPowerOfTwo();

    @ParameterizedTest
    @MethodSource("source")
    void test(TestCase testCase) {
        assertEquals(testCase.expected, isPowerOfTwo.isPowerOfTwo(testCase.n));
    }

}