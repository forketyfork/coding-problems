package com.forketyfork.codingproblems;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JumpGameTest {

    private static record TestCase(int[] array, boolean expected) {

    }

    public static Stream<TestCase> source() {
        return Stream.of(
                new TestCase(new int[] {0}, true),
                new TestCase(new int[] {1, 2, 3}, true),
                new TestCase(new int[] {2, 3, 1, 1, 4}, true),
                new TestCase(new int[] {3, 2, 1, 0, 4}, false),
                new TestCase(new int[] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, 10}, false)
        );
    }

    private JumpGame jumpGame = new JumpGame();

    @ParameterizedTest
    @MethodSource("source")
    public void test(TestCase testCase) {
        assertEquals(testCase.expected, jumpGame.canJump(testCase.array));
    }

}