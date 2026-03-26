package com.forketyfork.codingproblems;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FibonacciSequenceTest {

    private static record TestCase(int source, List<Integer> expected) {

    }

    @ParameterizedTest
    @MethodSource("source")
    void test(TestCase testCase) {
        assertEquals(testCase.expected, new FibonacciSequence().generate(testCase.source));
    }

    public static Stream<TestCase> source() {
        return Stream.of(
                new TestCase(0, List.of()),
                new TestCase(1, List.of(0)),
                new TestCase(2, List.of(0, 1)),
                new TestCase(3, List.of(0, 1, 1)),
                new TestCase(5, List.of(0, 1, 1, 2, 3)),
                new TestCase(8, List.of(0, 1, 1, 2, 3, 5, 8, 13)),
                new TestCase(10, List.of(0, 1, 1, 2, 3, 5, 8, 13, 21, 34))
        );
    }

}
