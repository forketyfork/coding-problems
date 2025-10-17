package com.forketyfork.codingproblems;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidPalindromeTest {

    private static record TestCase(String string, boolean expected) {

    }

    public static Stream<TestCase> source() {
        return Stream.of(
                // Empty and single character
                new TestCase("", true),
                new TestCase(" ", true),
                new TestCase("a", true),
                new TestCase("A", true),
                new TestCase("0", true),
                // Two characters
                new TestCase("aa", true),
                new TestCase("ab", false),
                new TestCase("Aa", true),  // case insensitive
                new TestCase("A a", true), // with space
                // Odd length palindromes
                new TestCase("aba", true),
                new TestCase("abcba", true),
                new TestCase("racecar", true),
                // Even length palindromes
                new TestCase("abba", true),
                new TestCase("aabbaa", true),
                // Non-palindromes
                new TestCase("abc", false),
                new TestCase("abcbd", false),
                new TestCase("hello", false),
                // With special characters and spaces
                new TestCase(",abcb a ", true),
                new TestCase(",abcb d ", false),
                new TestCase("A man, a plan, a canal: Panama", true),
                new TestCase("race a car", false),
                // Only special characters
                new TestCase(".,!?", true),
                new TestCase("   ", true),
                new TestCase("!@#$%", true),
                // Alphanumeric mix
                new TestCase("a1b2b1a", true),
                new TestCase("0P0", true),
                new TestCase("a1b2c1a", false),
                // Case sensitivity
                new TestCase("Aa", true),
                new TestCase("AaBbAa", true),
                new TestCase("AaBbCc", false),
                // Numbers only
                new TestCase("12321", true),
                new TestCase("12345", false),
                // Mixed alphanumeric with punctuation
                new TestCase("A1B2B1A", true),
                new TestCase("Was it a car or a cat I saw?", true),
                new TestCase("Madam, I'm Adam", true),
                new TestCase("Never odd or even", true),
                new TestCase("This is not a palindrome", false)
        );
    }

    @ParameterizedTest
    @MethodSource("source")
    void test(TestCase testCase) {
        assertEquals(testCase.expected, new ValidPalindrome().isPalindrome(testCase.string));
    }

}
