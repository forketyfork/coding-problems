package com.forketyfork.codingproblems;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PascalTriangleTest {

    private static record TestCase(int numRows, List<List<Integer>> expected) {

    }

    public static Stream<TestCase> source() {
        return Stream.of(
                new TestCase(1, Collections.singletonList(Collections.singletonList(1))),
                new TestCase(5, Arrays.asList(
                        Collections.singletonList(1),
                        Arrays.asList(1, 1),
                        Arrays.asList(1, 2, 1),
                        Arrays.asList(1, 3, 3, 1),
                        Arrays.asList(1, 4, 6, 4, 1)))
        );
    }

    private final PascalTriangle pascalTriangle = new PascalTriangle();

    @ParameterizedTest
    @MethodSource("source")
    void test(TestCase testCase) {
        assertEquals(testCase.expected, pascalTriangle.generate(testCase.numRows));
    }

}
