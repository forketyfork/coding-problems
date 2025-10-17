package com.forketyfork.codingproblems;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OneAwayTest {

    private record TestCase(String s1, String s2, boolean expected) {

    }

    public static Stream<TestCase> source() {
        return Stream.of(
                // Remove one character
                new TestCase("pale", "ple", true),
                new TestCase("pales", "pale", true),
                new TestCase("apple", "aple", true),
                new TestCase("abc", "ac", true),
                new TestCase("abc", "ab", true),
                new TestCase("abc", "bc", true),
                // Insert one character (reverse of remove)
                new TestCase("ple", "pale", true),
                new TestCase("pale", "pales", true),
                new TestCase("aple", "apple", true),
                // Replace one character
                new TestCase("pale", "bale", true),
                new TestCase("pale", "pble", true),
                new TestCase("pale", "pane", true),
                new TestCase("pale", "pald", true),
                new TestCase("a", "b", true),
                new TestCase("cat", "bat", true),
                new TestCase("cat", "cbt", true),
                new TestCase("cat", "caz", true),
                // Multiple edits needed (should be false)
                new TestCase("pale", "bake", false),
                new TestCase("abc", "xyz", false),
                new TestCase("ab", "ba", false),
                // Empty string cases
                new TestCase("", "", true),   // Zero edits
                new TestCase("", "a", true),  // Insert one
                new TestCase("a", "", true),  // Remove one
                new TestCase("", "ab", false), // Insert two
                new TestCase("ab", "", false), // Remove two
                // Same strings (zero edits)
                new TestCase("ab", "ab", true),
                new TestCase("abc", "abc", true),
                new TestCase("hello", "hello", true),
                // Length difference > 1
                new TestCase("ab", "abcd", false),
                new TestCase("abcd", "ab", false),
                new TestCase("a", "abc", false),
                new TestCase("abc", "a", false),
                // Single character
                new TestCase("a", "a", true),
                new TestCase("x", "y", true),
                // Long strings with one edit
                new TestCase("abcdefghij", "abcdefghi", true),  // Remove last
                new TestCase("abcdefghij", "abcdefghijk", true), // Insert last
                new TestCase("abcdefghij", "abcxefghij", true),  // Replace middle
                // Long strings with multiple edits
                new TestCase("abcdefghij", "abcxefyhij", false), // Replace two
                new TestCase("abcdefghij", "abdefghij", false),  // Remove two
                // Edge case: consecutive differences
                new TestCase("abcd", "axcd", true),   // One replacement
                new TestCase("abcd", "axyd", false),  // Two replacements
                // Different lengths with edits
                new TestCase("intention", "execution", false), // Many edits
                new TestCase("sitting", "sitting", true),      // Zero edits
                new TestCase("kitten", "sitten", true),        // One replacement
                new TestCase("saturday", "sunday", false)      // Multiple edits
        );
    }

    private final OneAway oneAway = new OneAway();

    @ParameterizedTest
    @MethodSource("source")
    void test(TestCase testCase) {
        assertEquals(testCase.expected, oneAway.isOneEditAway(testCase.s1, testCase.s2));
    }

}