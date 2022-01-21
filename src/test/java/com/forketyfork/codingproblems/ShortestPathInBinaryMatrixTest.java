package com.forketyfork.codingproblems;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShortestPathInBinaryMatrixTest {

    private record TestCase(int[][] matrix, int expected) {

    }

    public static Stream<TestCase> source() {
        return Stream.of(
                new TestCase(new int[][] {
                        {0, 0, 0},
                        {1, 1, 0},
                        {1, 1, 0}
                }, 4),
                new TestCase(new int[][] {
                        {1, 0, 0},
                        {1, 1, 0},
                        {1, 1, 0}
                }, -1)
        );
    }

    @ParameterizedTest
    @MethodSource("source")
    void test(TestCase testCase) {
        assertEquals(testCase.expected, new ShortestPathInBinaryMatrix().shortestPathBinaryMatrix(testCase.matrix));
    }

}