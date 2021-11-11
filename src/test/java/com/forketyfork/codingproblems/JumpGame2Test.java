package com.forketyfork.codingproblems;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JumpGame2Test {

    private static record TestCase(int[] array, int expected) {

    }

    public static Stream<TestCase> source() {
        return Stream.of(
                new TestCase(new int[] {1, 2, 3}, 2),
                new TestCase(new int[] {0}, 0),
                new TestCase(new int[] {}, 0),
                new TestCase(new int[] {2, 3, 1, 1, 4}, 2),
                new TestCase(new int[] {2, 3, 0, 1, 4}, 2),
                new TestCase(new int[] {5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0}, 3),
                new TestCase(new int[] {
                        5, 6, 4, 4, 6, 9, 4, 4, 7, 4, 4, 8, 2, 6, 8, 1, 5, 9, 6, 5, 2, 7, 9, 7, 9, 6, 9, 4, 1, 6, 8, 8,
                        4, 4, 2, 0, 3, 8, 5
                }, 5)
        );
    }

    private final JumpGame2 jumpGame2 = new JumpGame2();

    @ParameterizedTest
    @MethodSource("source")
    void test(TestCase testCase) {
        assertEquals(testCase.expected, jumpGame2.jump(testCase.array));
    }

}