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
                // Basic case with spaces in middle
                new TestCase("Mr John Smith    ".toCharArray(), 13, "Mr%20John%20Smith".toCharArray()),
                // Leading space
                new TestCase(" Mr John Smith      ".toCharArray(), 14, "%20Mr%20John%20Smith".toCharArray()),
                // Empty string
                new TestCase(new char[] {}, 0, new char[] {}),
                // Single character
                new TestCase("a".toCharArray(), 1, "a".toCharArray()),
                // Single space
                new TestCase("   ".toCharArray(), 1, "%20".toCharArray()),
                // No spaces
                new TestCase("hello".toCharArray(), 5, "hello".toCharArray()),
                // Multiple consecutive spaces
                new TestCase("a  b      ".toCharArray(), 4, "a%20%20b".toCharArray()),
                // Trailing space
                new TestCase("hello    ".toCharArray(), 6, "hello%20".toCharArray()),
                // Space at beginning and end
                new TestCase(" a        ".toCharArray(), 3, "%20a%20".toCharArray()),
                // All spaces
                new TestCase("         ".toCharArray(), 3, "%20%20%20".toCharArray()),
                // Single word (no replacement needed)
                new TestCase("word".toCharArray(), 4, "word".toCharArray()),
                // Complex sentence
                new TestCase("Hello World Test      ".toCharArray(), 16, "Hello%20World%20Test".toCharArray()),
                // Two words
                new TestCase("ab   ".toCharArray(), 3, "a%20b".toCharArray())
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