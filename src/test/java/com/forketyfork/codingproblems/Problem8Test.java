package com.forketyfork.codingproblems;

import com.forketyfork.codingproblems.structures.TreeNode;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static com.forketyfork.codingproblems.structures.TreeNode.node;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Problem8Test {

    private static record TestCase(TreeNode node, int expected) {

    }

    public static Stream<TestCase> source() {
        return Stream.of(
                new TestCase(node(0, null, null), 1),
                new TestCase(
                        node(0,
                                node(1, null, null),
                                node(0,
                                        node(1,
                                                node(1, null, null),
                                                node(1, null, null)),
                                        node(0, null, null))),
                        5
                ),
                new TestCase(
                        node(0,
                                node(0, null, null),
                                node(0, null, null)),
                        3
                )
        );
    }

    @ParameterizedTest
    @MethodSource("source")
    public void test(TestCase testCase) {
        assertEquals(testCase.expected, new Problem8().countUnivalTrees(testCase.node));
    }

}
