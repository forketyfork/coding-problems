package com.forketyfork.codingproblems;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class URLifyTest {

    private record TestCase(char[] str, int length, char[] expected) {

    }

    public static Stream<TestCase> source() {
        return Stream.of(
                new TestCase("Mr John Smith    ".toCharArray(), 13, "Mr%20John%20Smith".toCharArray()),
                new TestCase(" Mr John Smith      ".toCharArray(), 14, "%20Mr%20John%20Smith".toCharArray()),
                new TestCase(new char[] {}, 0, new char[] {})
        );
    }

    private final URLify urlify = new URLify();

    @ParameterizedTest
    @MethodSource("source")
    void test(TestCase testCase) {
        urlify.replaceSpaces(testCase.str, testCase.length);
        assertArrayEquals(testCase.expected, testCase.str);
    }

}