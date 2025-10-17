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
                // Powers of two
                new TestCase(1, true),       // 2^0
                new TestCase(2, true),       // 2^1
                new TestCase(4, true),       // 2^2
                new TestCase(8, true),       // 2^3
                new TestCase(16, true),      // 2^4
                new TestCase(32, true),      // 2^5
                new TestCase(64, true),      // 2^6
                new TestCase(128, true),     // 2^7
                new TestCase(256, true),     // 2^8
                new TestCase(512, true),     // 2^9
                new TestCase(1024, true),    // 2^10
                new TestCase(1073741824, true), // 2^30 (largest power of 2 in int range)
                // Non-powers of two
                new TestCase(3, false),
                new TestCase(5, false),
                new TestCase(6, false),
                new TestCase(7, false),
                new TestCase(9, false),
                new TestCase(10, false),
                new TestCase(15, false),
                new TestCase(17, false),
                new TestCase(100, false),
                new TestCase(1000, false),
                // Edge cases
                new TestCase(0, false),      // Zero is not a power of two
                new TestCase(-1, false),     // Negative numbers
                new TestCase(-2, false),     // Even negative
                new TestCase(-16, false),    // Negative power of two value
                new TestCase(Integer.MIN_VALUE, false), // -2^31
                new TestCase(Integer.MAX_VALUE, false)  // 2^31 - 1 (not a power of 2)
        );
    }

    private final IsPowerOfTwo isPowerOfTwo = new IsPowerOfTwo();

    @ParameterizedTest
    @MethodSource("source")
    void test(TestCase testCase) {
        assertEquals(testCase.expected, isPowerOfTwo.isPowerOfTwo(testCase.n));
    }

}