package com.forketyfork.codingproblems;

import com.forketyfork.codingproblems.structures.TreeNode;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static com.forketyfork.codingproblems.structures.TreeNode.node;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumDepthBinaryTreeTest {

    private static record TestCase(TreeNode tree, int expected) {

    }

    @ParameterizedTest
    @MethodSource("source")
    void test(TestCase testCase) {
        assertEquals(testCase.expected, new MaximumDepthBinaryTree().maxDepth(testCase.tree));
    }

    public static Stream<TestCase> source() {
        return Stream.of(
                new TestCase(null, 0),
                new TestCase(node(1), 1),
                new TestCase(node(3,
                        node(9),
                        node(20,
                                node(15),
                                node(7))), 3),
                new TestCase(node(1, null, node(1)), 2)

        );
    }

}