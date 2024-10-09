package com.forketyfork.codingproblems;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PalindromePermutationTest {

    private record TestCase(String s, boolean expected) {

    }

    public static Stream<TestCase> source() {
        return Stream.of(
                new TestCase("Tact Coa", true),
                new TestCase("Tacat Coa", false),
                new TestCase("Tacat Cooa", true),
                new TestCase("abba", true),
                new TestCase("abbat", true),
                new TestCase("abbate", false),
                new TestCase("", true),
                new TestCase("a", true),
                new TestCase("ao", false),
                new TestCase("aa", true)
        );
    }

    private final PalindromePermutation palindromePermutation = new PalindromePermutation();

    @ParameterizedTest
    @MethodSource("source")
    void test(TestCase testCase) {
        assertEquals(testCase.expected, palindromePermutation.isPermutationOfAPalindrome(testCase.s));
    }

}