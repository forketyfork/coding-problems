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
                new TestCase("pale", "ple", true),
                new TestCase("pales", "pale", true),
                new TestCase("pale", "bale", true),
                new TestCase("pale", "bake", false),
                new TestCase("", "a", true),
                new TestCase("a", "", true),
                new TestCase("a", "b", true),
                new TestCase("", "ab", false),
                new TestCase("ab", "ab", true),
                new TestCase("", "", true),
                new TestCase("ab", "abcd", false),
                new TestCase("abcd", "ab", false)
        );
    }

    private final OneAway oneAway = new OneAway();

    @ParameterizedTest
    @MethodSource("source")
    void test(TestCase testCase) {
        assertEquals(testCase.expected, oneAway.isOneEditAway(testCase.s1, testCase.s2));
    }

}