package com.forketyfork.codingproblems;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ValidAnagramsTest {

    private static record TestCase(String s, String t, boolean expected) {

    }

    public static Stream<TestCase> source() {
        return Stream.of(
                // Basic anagrams
                new TestCase("anagram", "nagaram", true),
                new TestCase("rat", "car", false),
                // Empty strings
                new TestCase("", "", true),
                // Single character
                new TestCase("a", "a", true),
                new TestCase("a", "b", false),
                // Different lengths (cannot be anagrams)
                new TestCase("a", "ab", false),
                new TestCase("ab", "a", false),
                new TestCase("abc", "abcd", false),
                // Same letters, different frequencies
                new TestCase("aab", "abb", false),
                new TestCase("aaa", "aab", false),
                // Multiple occurrences
                new TestCase("aacc", "ccaa", true),
                new TestCase("aabbcc", "abcabc", true),
                // All same character
                new TestCase("aaa", "aaa", true),
                new TestCase("zzz", "zzz", true),
                new TestCase("aaa", "bbb", false),
                // Long strings
                new TestCase("abcdefghijklmnopqrstuvwxyz", "zyxwvutsrqponmlkjihgfedcba", true),
                new TestCase("abcdefghijklmnopqrstuvwxyz", "abcdefghijklmnopqrstuvwxy", false),
                // Repeated patterns
                new TestCase("abab", "baba", true),
                new TestCase("abcd", "dcba", true),
                new TestCase("abcd", "dcbe", false),
                // Real words
                new TestCase("listen", "silent", true),
                new TestCase("elbow", "below", true),
                new TestCase("heart", "earth", true),
                new TestCase("cinema", "iceman", true),
                new TestCase("hello", "world", false),
                // Edge cases with character frequencies
                new TestCase("ab", "aa", false),
                new TestCase("aa", "bb", false),
                // Longer anagrams
                new TestCase("restful", "fluster", true),
                new TestCase("conversation", "conservation", false),
                // Same string
                new TestCase("test", "test", true),
                new TestCase("hello", "hello", true)
        );
    }

    @ParameterizedTest
    @MethodSource("source")
    void test(TestCase testCase) {
        assertEquals(testCase.expected, new ValidAnagrams().isAnagram(testCase.s, testCase.t),
            "Testing if \"" + testCase.s + "\" and \"" + testCase.t + "\" are anagrams");
    }

}
