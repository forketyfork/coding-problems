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

    public int maxDepth(TreeNode root) {
        // base case when the tree is empty
        if (root == null) {
            return 0;
        }
        // recursive call with the left and the right part of the tree
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

}
