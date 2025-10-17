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
                // Overflow edge case: MIN_VALUE / -1 should return MAX_VALUE
                new DivideTwoIntegersTest.TestCase(-2147483648, -1, 2147483647),
                // Large negative dividend
                new DivideTwoIntegersTest.TestCase(-2147483648, -3, 715827882),
                new DivideTwoIntegersTest.TestCase(-2147483648, 2, -1073741824),
                // Basic positive division
                new DivideTwoIntegersTest.TestCase(10, 3, 3),
                new DivideTwoIntegersTest.TestCase(7, 3, 2),
                // Exact division
                new DivideTwoIntegersTest.TestCase(10, 2, 5),
                new DivideTwoIntegersTest.TestCase(100, 10, 10),
                // Divisor = 1 optimization
                new DivideTwoIntegersTest.TestCase(100, 1, 100),
                new DivideTwoIntegersTest.TestCase(-100, 1, -100),
                // Dividend = 0
                new DivideTwoIntegersTest.TestCase(0, 1, 0),
                new DivideTwoIntegersTest.TestCase(0, 100, 0),
                // Dividend < divisor
                new DivideTwoIntegersTest.TestCase(3, 10, 0),
                new DivideTwoIntegersTest.TestCase(1, 2, 0),
                // Negative divisor
                new DivideTwoIntegersTest.TestCase(10, -3, -3),
                new DivideTwoIntegersTest.TestCase(-10, -3, 3),
                // Both negative (same sign = positive result)
                new DivideTwoIntegersTest.TestCase(-7, -3, 2),
                // Large values
                new DivideTwoIntegersTest.TestCase(2147483647, 1, 2147483647),
                new DivideTwoIntegersTest.TestCase(2147483647, 2, 1073741823)
        );
    }

}
