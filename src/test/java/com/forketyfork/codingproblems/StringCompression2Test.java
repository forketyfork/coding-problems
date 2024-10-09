package com.forketyfork.codingproblems;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringCompression2Test {

    private record TestCase(String s, String expected) {

    }

    public static Stream<TestCase> source() {
        return Stream.of(
                new TestCase("aabcccccaaa", "a2b1c5a3"),
                new TestCase("aaaaaaaaaaaabbbbbbbbbbbbb", "a12b13"),
                new TestCase("abcd", "abcd")
        );
    }

    private final StringCompression2 stringCompression2 = new StringCompression2();

    @ParameterizedTest
    @MethodSource("source")
    void test(TestCase testCase) {
        assertEquals(testCase.expected, stringCompression2.compress(testCase.s));
    }

}