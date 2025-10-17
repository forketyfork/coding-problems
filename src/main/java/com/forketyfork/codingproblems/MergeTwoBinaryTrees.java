package com.forketyfork.codingproblems;

import com.forketyfork.codingproblems.structures.TreeNode;

import static com.forketyfork.codingproblems.structures.TreeNode.node;

/**
 * This problem was asked by Salesforce.
 * <p>
 * Write a program to merge two binary trees. Each node in the new tree should hold a value
 * equal to the sum of the values of the corresponding nodes of the input trees.
 * <p>
 * If only one input tree has a node in a given position, the corresponding node
 * in the new tree should match that input node.
 *
 * @see "Daily Coding Problem #422"
 * @see <a href="https://leetcode.com/problems/merge-two-binary-trees/">LeetCode #617. Merge Two Binary Trees</a>
 */
public class MergeTwoBinaryTrees {

    /**
     * Merges two binary trees by summing values of overlapping nodes.
     * If only one tree has a node at a position, that node is used directly.
     *
     * @param tree1 the first binary tree
     * @param tree2 the second binary tree
     * @return a new binary tree representing the merged result
     *
     * <p>Time Complexity: O(min(n1, n2)) where n1 and n2 are the number of nodes in each tree
     * <p>Space Complexity: O(min(h1, h2)) for recursion stack, where h1 and h2 are tree heights
     *
     * <p>Algorithm: Recursively traverse both trees in parallel. At each position:
     * - If both nodes exist: create new node with sum of values
     * - If only one exists: return that node
     * - If neither exists: return null
     */
    public TreeNode mergeTrees(TreeNode tree1, TreeNode tree2) {

        if (tree1 == null && tree2 == null) {
            return null;
        }

        if (tree1 == null) {
            return tree2;
        }

        if (tree2 == null) {
            return tree1;
        }

        // Both nodes exist: create new node with sum and recursively merge children
        return node(tree1.val + tree2.val,
                mergeTrees(tree1.left, tree2.left),
                mergeTrees(tree1.right, tree2.right));
    }

}
