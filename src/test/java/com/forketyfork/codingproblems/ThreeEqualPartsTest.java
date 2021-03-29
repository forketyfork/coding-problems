package com.forketyfork.codingproblems;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ThreeEqualPartsTest {

    private static record TestCase(int[] array, int[] expected) {

    }

    public static Stream<TestCase> source() {
        return Stream.of(
                new TestCase(new int[] {1, 0, 1, 0, 1}, new int[] {0, 3}),
                new TestCase(new int[] {1, 1, 0, 1, 1}, new int[] {-1, -1}),
                new TestCase(new int[] {1, 1, 0, 0, 1}, new int[] {0, 2}),
                new TestCase(new int[] {1, 0, 1, 1, 0}, new int[] {-1, -1}),
                new TestCase(new int[] {0, 1, 0, 1, 1}, new int[] {1, 4}),
                new TestCase(new int[] {0, 1, 0, 0, 0, 0, 1}, new int[] {-1, -1}),
                new TestCase(new int[] {0, 0, 0, 0, 0}, new int[] {0, 4}),
                new TestCase(new int[] {
                        1, 1, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0,
                        0, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0
                }, new int[] {15, 32})

        );
    }

    private ThreeEqualParts threeEqualParts = new ThreeEqualParts();

    @ParameterizedTest
    @MethodSource("source")
    public void test(TestCase testCase) {
        assertArrayEquals(testCase.expected, threeEqualParts.threeEqualParts(testCase.array));
    }

}
