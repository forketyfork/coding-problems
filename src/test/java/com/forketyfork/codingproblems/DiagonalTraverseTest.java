package com.forketyfork.codingproblems;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class DiagonalTraverseTest {

    private static record TestCase(int[][] source, int[] expected) {

    }

    @ParameterizedTest
    @MethodSource("source")
    void test(DiagonalTraverseTest.TestCase testCase) {
        assertArrayEquals(testCase.expected, new DiagonalTraverse().findDiagonalOrder(testCase.source));
    }

    public static Stream<DiagonalTraverseTest.TestCase> source() {
        return Stream.of(
                new DiagonalTraverseTest.TestCase(new int[][] {
                        new int[] {1, 2, 3}, new int[] {4, 5, 6}, new int[] {7, 8, 9}
                }, new int[] {1, 2, 4, 7, 5, 3, 6, 8, 9}),
                new DiagonalTraverseTest.TestCase(new int[][] {
                        new int[] {1, 2}, new int[] {3, 4}
                }, new int[] {1, 2, 3, 4})
        );
    }

}
