package com.forketyfork.codingproblems;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WordBreakTest {

    private static record TestCase(String s, List<String> wordDict, boolean expected) {

    }

    public static Stream<TestCase> source() {
        return Stream.of(
                // Basic cases
                new TestCase(
                    "leetcode",
                    List.of("leet", "code"),
                    true
                ),
                new TestCase(
                    "applepenapple",
                    List.of("apple", "pen"),
                    true
                ),
                new TestCase(
                    "catsandog",
                    List.of("cats", "dog", "sand", "and", "cat"),
                    false
                ),
                // Empty string
                new TestCase(
                    "",
                    List.of("a", "b"),
                    true  // Empty string can be segmented (zero words)
                ),
                // Single character
                new TestCase(
                    "a",
                    List.of("a"),
                    true
                ),
                new TestCase(
                    "a",
                    List.of("b"),
                    false
                ),
                // Word reuse
                new TestCase(
                    "aaaaaaa",
                    List.of("aa", "aaa"),
                    true
                ),
                new TestCase(
                    "aaaaaaa",
                    List.of("aaaa", "aaa"),
                    true
                ),
                // No match
                new TestCase(
                    "abcd",
                    List.of("a", "abc", "b", "d"),
                    false  // Can't make 'c' separately
                ),
                // Overlapping possibilities
                new TestCase(
                    "cars",
                    List.of("car", "ca", "rs"),
                    true
                ),
                // Word that is prefix of another
                new TestCase(
                    "catsanddog",
                    List.of("cat", "cats", "and", "sand", "dog"),
                    true
                ),
                // Multiple ways to segment
                new TestCase(
                    "pineapplepenapple",
                    List.of("apple", "pen", "applepen", "pine", "pineapple"),
                    true
                ),
                // Cannot segment - missing piece
                new TestCase(
                    "abcdef",
                    List.of("abc", "def", "gh"),
                    true
                ),
                // Long word
                new TestCase(
                    "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
                    List.of("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"),
                    false
                ),
                // Word requires multiple segments
                new TestCase(
                    "abcd",
                    List.of("ab", "cd"),
                    true
                ),
                // Greedy approach wouldn't work
                new TestCase(
                    "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                    List.of("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa", "ba"),
                    true
                ),
                // Dictionary with unused words
                new TestCase(
                    "dogs",
                    List.of("dog", "s", "gs", "cat", "bird"),
                    true
                ),
                // All single characters
                new TestCase(
                    "abc",
                    List.of("a", "b", "c"),
                    true
                ),
                // Single word exact match
                new TestCase(
                    "hello",
                    List.of("hello"),
                    true
                ),
                new TestCase(
                    "hello",
                    List.of("world"),
                    false
                ),
                // Repeated characters
                new TestCase(
                    "bb",
                    List.of("a", "b", "bbb", "bbbb"),
                    true
                ),
                // Complex pattern
                new TestCase(
                    "goalspecial",
                    List.of("go", "goal", "goals", "special"),
                    true
                )
        );
    }

    @ParameterizedTest
    @MethodSource("source")
    void test(TestCase testCase) {
        assertEquals(testCase.expected, new WordBreak().wordBreak(testCase.s, testCase.wordDict),
            "Word break for \"" + testCase.s + "\" with dictionary " + testCase.wordDict +
            " should be " + testCase.expected);
    }

}
