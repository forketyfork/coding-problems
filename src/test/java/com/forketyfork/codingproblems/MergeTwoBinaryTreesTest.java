package com.forketyfork.codingproblems;

import com.forketyfork.codingproblems.structures.TreeNode;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static com.forketyfork.codingproblems.structures.TreeNode.node;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MergeTwoBinaryTreesTest {

    private static record TestCase(TreeNode tree1, TreeNode tree2, TreeNode expected) {

    }

    @ParameterizedTest
    @MethodSource("source")
    public void test(TestCase testCase) {
        assertEquals(testCase.expected, new MergeTwoBinaryTrees().mergeTrees(testCase.tree1, testCase.tree2));
    }

    public static Stream<TestCase> source() {
        return Stream.of(
                new TestCase(null, null, null),
                new TestCase(node(1), node(2), node(3)),
                new TestCase(node(1), null, node(1)),
                new TestCase(null, node(1), node(1)),
                new TestCase(node(1, node(2), node(3)),
                        node(1, node(7), node(8)),
                        node(2, node(9), node(11))),
                new TestCase(node(1, node(2), node(3)),
                        node(1, node(7), null),
                        node(2, node(9), node(3))),
                new TestCase(node(1, node(2), null),
                        node(1, node(7), node(8)),
                        node(2, node(9), node(8)))

        );
    }

}
