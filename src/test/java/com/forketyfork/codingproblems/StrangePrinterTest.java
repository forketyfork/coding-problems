package com.forketyfork.codingproblems;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StrangePrinterTest {

    private static record TestCase(String string, int expected) {

    }

    public static Stream<TestCase> source() {
        return Stream.of(
                new TestCase("", 0),
                new TestCase("a", 1),
                new TestCase("aaa", 1),
                new TestCase("aaabbb", 2),
                new TestCase("aba", 2),
                new TestCase("ababc", 4),
                new TestCase("abcabc", 5),
                new TestCase("baacdddaaddaaaaccbddbcabdaabdbbcdcbbbacbddcabcaaa", 19),
                new TestCase("abacababacab", 7)
        );
    }

    private StrangePrinter strangePrinter = new StrangePrinter();

    @ParameterizedTest
    @MethodSource("source")
    public void test(TestCase testCase) {
        assertEquals(testCase.expected, strangePrinter.strangePrinter(testCase.string));
    }

}
