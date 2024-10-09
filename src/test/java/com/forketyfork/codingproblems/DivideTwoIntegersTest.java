package com.forketyfork.codingproblems;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

class DivideTwoIntegersTest {

    private static record TestCase(int dividend, int divisor, int expected) {

    }

    @ParameterizedTest
    @MethodSource("source")
    void test(DivideTwoIntegersTest.TestCase testCase) {
        assertEquals(testCase.expected, new DivideTwoIntegers().divide(testCase.dividend, testCase.divisor));
    }

    public static Stream<DivideTwoIntegersTest.TestCase> source() {
        return Stream.of(
                new DivideTwoIntegersTest.TestCase(-2147483648, -3, 715827882),
                new DivideTwoIntegersTest.TestCase(-2147483648, 2, -1073741824)
        );
    }

}
