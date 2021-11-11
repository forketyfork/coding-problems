package com.forketyfork.codingproblems;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchInsertPositionTest {

    private static record TestCase(int[] array, int target, int expected) {

    }

    public static Stream<TestCase> source() {
        return Stream.of(
                new TestCase(new int[] {0}, 0, 0),
                new TestCase(new int[] {1}, 0, 0),
                new TestCase(new int[] {0}, 1, 1),
                new TestCase(new int[] {1, 2, 5, 6}, 0, 0),
                new TestCase(new int[] {1, 3}, 4, 2),
                new TestCase(new int[] {2, 7, 8, 9, 10}, 9, 3),
                new TestCase(new int[] {1, 3, 5, 6}, 5, 2),
                new TestCase(new int[] {1, 3, 5, 6}, 7, 4)
        );
    }

    @ParameterizedTest
    @MethodSource("source")
    void test(TestCase testCase) {
        assertEquals(testCase.expected, new SearchInsertPosition().searchInsert(testCase.array, testCase.target));
    }

}