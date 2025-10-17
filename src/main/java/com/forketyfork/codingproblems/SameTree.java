package com.forketyfork.codingproblems;

import com.forketyfork.codingproblems.structures.TreeNode;

/**
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 * Two binary trees are considered the same if they are structurally identical and the nodes have the same values.
 *
 * @see <a href="https://leetcode.com/problems/same-tree/">LeetCode #100. Same Tree</a>
 */
public class SameTree {

    /**
     * Checks if two binary trees are identical using recursive comparison.
     * Trees are identical if they have the same structure and node values.
     *
     * @param p the root of the first tree
     * @param q the root of the second tree
     * @return true if the trees are identical, false otherwise
     *
     * <p>Time Complexity: O(n) where n is the number of nodes (we visit each node once)
     * <p>Space Complexity: O(h) where h is the height (recursion stack)
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return (p == null && q == null)
                || (p != null && q != null
                && p.val == q.val
                && isSameTree(p.left, q.left)
                && isSameTree(p.right, q.right));
    }
}