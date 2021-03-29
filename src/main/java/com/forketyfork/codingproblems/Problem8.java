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
 * 0
 * / \
 * 1   0
 * / \
 * 1   0
 * / \
 * 1   1
 *
 * @see "Daily Coding Problem #8"
 */
public class Problem8 {

    private int count;

    public int countUnivalTrees(TreeNode node) {
        isUnivalTree(node);
        return count;
    }

    public boolean isUnivalTree(TreeNode node) {
        if (node == null) {
            return true;
        }
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
