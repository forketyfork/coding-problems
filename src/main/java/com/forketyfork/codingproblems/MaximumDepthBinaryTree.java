package com.forketyfork.codingproblems;

import com.forketyfork.codingproblems.structures.TreeNode;

/**
 * Given the root of a binary tree, return its maximum depth.
 * <p>
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest
 * leaf node.
 *
 * @see <a href="https://leetcode.com/problems/maximum-depth-of-binary-tree/">LeetCode #104. Maximum Depth of Binary Tree</a>
 */
public class MaximumDepthBinaryTree {

    /**
     * Calculates the maximum depth of a binary tree using recursion.
     * The depth is the number of nodes along the longest path from root to leaf.
     *
     * @param root the root of the binary tree
     * @return the maximum depth of the tree
     *
     * <p>Time Complexity: O(n) where n is the number of nodes in the tree
     * <p>Space Complexity: O(h) where h is the height of the tree (recursion stack)
     */
    public int maxDepth(TreeNode root) {
        // Base case: empty tree has depth 0
        if (root == null) {
            return 0;
        }
        // Recursive case: 1 (current node) + max depth of left or right subtree
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

}
