package com.forketyfork.codingproblems;

import com.forketyfork.codingproblems.structures.TreeNode;

/**
 * This problem was asked by Google.
 * <p>
 * A unival tree (which stands for "universal value") is a tree where all nodes under it have the same value.
 * <p>
 * Given the root to a binary tree, count the number of unival subtrees.
 * <p>
 * For example, the following tree has 5 unival subtrees:
 * <p>
 * <pre>
 *       0
 *      / \
 *     1   0
 *        / \
 *       1   0
 *      / \
 *     1   1
 * </pre>
 *
 * @see "Daily Coding Problem #8"
 */
public class Problem8 {

    private int count;

    /**
     * Counts the total number of unival subtrees in the given binary tree.
     * A unival subtree is a subtree where all nodes have the same value.
     *
     * @param node the root of the binary tree
     * @return the total number of unival subtrees
     *
     * <p>Time Complexity: O(n) where n is the number of nodes in the tree
     * <p>Space Complexity: O(h) where h is the height of the tree (recursion stack)
     */
    public int countUnivalTrees(TreeNode node) {
        isUnivalTree(node);
        return count;
    }

    /**
     * Recursively checks if a subtree is a unival tree (all nodes have the same value).
     * This method performs a post-order traversal, checking children before the parent.
     * If a subtree is unival, it increments the global count.
     *
     * @param node the root of the subtree to check
     * @return true if the subtree rooted at node is a unival tree, false otherwise
     *
     * <p>A subtree is unival if:
     * 1. Both left and right subtrees are unival (or null)
     * 2. The left child (if exists) has the same value as the node
     * 3. The right child (if exists) has the same value as the node
     */
    public boolean isUnivalTree(TreeNode node) {
        if (node == null) {
            return true;
        }
        // Post-order traversal: check children first
        boolean result = isUnivalTree(node.left)
                && isUnivalTree(node.right)
                && (node.left == null || node.left.val == node.val)
                && (node.right == null || node.right.val == node.val);
        if (result) {
            count++;
        }
        return result;
    }

}
