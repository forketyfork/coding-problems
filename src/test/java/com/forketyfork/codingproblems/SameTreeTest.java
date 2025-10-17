package com.forketyfork.codingproblems;

import com.forketyfork.codingproblems.structures.TreeNode;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static com.forketyfork.codingproblems.structures.TreeNode.node;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SameTreeTest {

    private static record TestCase(TreeNode p, TreeNode q, boolean expected) {

    }

    public static Stream<TestCase> source() {
        return Stream.of(
                // Both null
                new TestCase(null, null, true),
                // One null, one not
                new TestCase(null, node(1), false),
                new TestCase(node(1), null, false),
                // Single node - same value
                new TestCase(node(1), node(1), true),
                // Single node - different values
                new TestCase(node(1), node(2), false),
                // Two nodes - identical
                new TestCase(
                    node(1, node(2), null),
                    node(1, node(2), null),
                    true
                ),
                new TestCase(
                    node(1, null, node(2)),
                    node(1, null, node(2)),
                    true
                ),
                // Two nodes - different structure
                new TestCase(
                    node(1, node(2), null),
                    node(1, null, node(2)),
                    false
                ),
                // Two nodes - same structure, different values
                new TestCase(
                    node(1, node(2), null),
                    node(1, node(3), null),
                    false
                ),
                // Three nodes - complete binary tree - identical
                new TestCase(
                    node(1, node(2), node(3)),
                    node(1, node(2), node(3)),
                    true
                ),
                // Three nodes - different values
                new TestCase(
                    node(1, node(2), node(3)),
                    node(1, node(2), node(4)),
                    false
                ),
                // Three nodes - different structure
                new TestCase(
                    node(1, node(2), node(3)),
                    node(1, node(2), null),
                    false
                ),
                // Larger tree - identical
                new TestCase(
                    node(1,
                        node(2, node(4), node(5)),
                        node(3)),
                    node(1,
                        node(2, node(4), node(5)),
                        node(3)),
                    true
                ),
                // Larger tree - different leaf values
                new TestCase(
                    node(1,
                        node(2, node(4), node(5)),
                        node(3)),
                    node(1,
                        node(2, node(4), node(6)),
                        node(3)),
                    false
                ),
                // Larger tree - missing node
                new TestCase(
                    node(1,
                        node(2, node(4), node(5)),
                        node(3)),
                    node(1,
                        node(2, node(4), null),
                        node(3)),
                    false
                ),
                // Skewed tree - left only - identical
                new TestCase(
                    node(1, node(2, node(3, node(4), null), null), null),
                    node(1, node(2, node(3, node(4), null), null), null),
                    true
                ),
                // Skewed tree - right only - identical
                new TestCase(
                    node(1, null, node(2, null, node(3, null, node(4)))),
                    node(1, null, node(2, null, node(3, null, node(4)))),
                    true
                ),
                // Skewed tree - different directions
                new TestCase(
                    node(1, node(2, node(3), null), null),
                    node(1, null, node(2, null, node(3))),
                    false
                ),
                // Negative values
                new TestCase(
                    node(-1, node(-2), node(-3)),
                    node(-1, node(-2), node(-3)),
                    true
                ),
                new TestCase(
                    node(-1, node(-2), node(-3)),
                    node(-1, node(-2), node(3)),
                    false
                ),
                // Zero values
                new TestCase(
                    node(0, node(0), node(0)),
                    node(0, node(0), node(0)),
                    true
                ),
                // Complex tree with multiple levels
                new TestCase(
                    node(5,
                        node(3, node(1), node(4)),
                        node(7, node(6), node(9))),
                    node(5,
                        node(3, node(1), node(4)),
                        node(7, node(6), node(9))),
                    true
                ),
                // Complex tree - one value different deep in tree
                new TestCase(
                    node(5,
                        node(3, node(1), node(4)),
                        node(7, node(6), node(9))),
                    node(5,
                        node(3, node(1), node(4)),
                        node(7, node(6), node(8))),
                    false
                )
        );
    }

    @ParameterizedTest
    @MethodSource("source")
    void test(TestCase testCase) {
        assertEquals(testCase.expected, new SameTree().isSameTree(testCase.p, testCase.q),
            "Expected trees to be " + (testCase.expected ? "identical" : "different"));
    }

}
