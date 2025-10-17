package com.forketyfork.codingproblems;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TribonacciTest {

    private static record TestCase(int n, int expected) {

    }

    public static Stream<TestCase> source() {
        return Stream.of(
                // Base cases
                new TestCase(0, 0),
                new TestCase(1, 1),
                new TestCase(2, 1),
                // Small values
                new TestCase(3, 2),   // 0 + 1 + 1 = 2
                new TestCase(4, 4),   // 1 + 1 + 2 = 4
                new TestCase(5, 7),   // 1 + 2 + 4 = 7
                new TestCase(6, 13),  // 2 + 4 + 7 = 13
                new TestCase(7, 24),  // 4 + 7 + 13 = 24
                new TestCase(8, 44),  // 7 + 13 + 24 = 44
                new TestCase(9, 81),  // 13 + 24 + 44 = 81
                new TestCase(10, 149), // 24 + 44 + 81 = 149
                // Medium values
                new TestCase(15, 3136),
                new TestCase(20, 66012),
                // Larger values
                new TestCase(25, 1389537),
                new TestCase(30, 29249425),
                // Maximum supported value (array size is 38)
                new TestCase(37, 2082876103)
        );
    }

    @ParameterizedTest
    @MethodSource("source")
    void test(TestCase testCase) {
        assertEquals(testCase.expected, new Tribonacci().tribonacci(testCase.n),
            "Tribonacci(" + testCase.n + ") should equal " + testCase.expected);
    }

}
