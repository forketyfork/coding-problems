package com.forketyfork.codingproblems;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ThousandSeparatorTest {

    private static record TestCase(int n, String expected) {

    }

    public static Stream<TestCase> source() {
        return Stream.of(
                new TestCase(987, "987"),
                new TestCase(1234, "1.234"),
                new TestCase(123456789, "123.456.789"),
                new TestCase(0, "0")
        );
    }

    private ThousandSeparator thousandSeparator = new ThousandSeparator();

    @ParameterizedTest
    @MethodSource("source")
    public void test(TestCase testCase) {
        assertEquals(testCase.expected, thousandSeparator.thousandSeparator(testCase.n));
    }

}