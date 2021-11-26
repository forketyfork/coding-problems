package com.forketyfork.codingproblems;

import com.forketyfork.codingproblems.structures.TreeNode;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static com.forketyfork.codingproblems.structures.TreeNode.node;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MostFrequentSubtreeSumTest {

    private static record TestCase(TreeNode tree, int[] expected) {

    }

    @ParameterizedTest
    @MethodSource("source")
    void test(TestCase testCase) {
        var expected = IntStream.of(testCase.expected)
                .boxed()
                .collect(Collectors.toList());
        var actual = IntStream.of(new MostFrequentSubtreeSum().findFrequentTreeSum(testCase.tree))
                .boxed()
                .collect(Collectors.toList());
        assertEquals(expected.size(), actual.size());
        assertTrue(expected.containsAll(actual));
        assertTrue(actual.containsAll(expected));
    }

    public static Stream<TestCase> source() {
        return Stream.of(
                new TestCase(node(5, node(2), node(-3)), new int[] {2, -3, 4}),
                new TestCase(node(5, node(2), node(-5)), new int[] {2})
        );
    }

}
