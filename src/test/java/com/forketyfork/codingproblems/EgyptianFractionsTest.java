package com.forketyfork.codingproblems;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EgyptianFractionsTest {

    private record TestCase(int num, int denom, Integer[] expected) {

    }

    @ParameterizedTest
    @MethodSource("source")
    void test(TestCase testCase) {
        assertArrayEquals(testCase.expected, new EgyptianFractions().egyptian(testCase.num, testCase.denom));
    }

    public static Stream<TestCase> source() {
        return Stream.of(
                new TestCase(4, 13, new Integer[] {4, 18, 468})
        );
    }

}
