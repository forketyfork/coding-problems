package com.forketyfork.codingproblems;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountAndSayTest {

    private static record TestCase(int n, String expected) {

    }

    @ParameterizedTest
    @MethodSource("source")
    public void test(TestCase testCase) {
        assertEquals(testCase.expected, new CountAndSay().countAndSay(testCase.n));
    }

    public static Stream<TestCase> source() {
        return Stream.of(
                new TestCase(1, "1"),
                new TestCase(2, "11"),
                new TestCase(3, "21"),
                new TestCase(4, "1211"),
                new TestCase(5, "111221"),
                new TestCase(6, "312211"),
                new TestCase(7, "13112221"),
                new TestCase(8, "1113213211")
        );
    }

}