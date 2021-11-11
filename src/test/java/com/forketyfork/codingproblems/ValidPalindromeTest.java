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
                new TestCase("", true),
                new TestCase("a", true),
                new TestCase("aa", true),
                new TestCase("ab", false),
                new TestCase("abcba", true),
                new TestCase("abcbd", false),
                new TestCase(",abcb a ", true),
                new TestCase(",abcb d ", false),
                new TestCase("A man, a plan, a canal: Panama", true)
        );
    }

    @ParameterizedTest
    @MethodSource("source")
    void test(TestCase testCase) {
        assertEquals(testCase.expected, new ValidPalindrome().isPalindrome(testCase.string));
    }

}
