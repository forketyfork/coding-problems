package com.forketyfork.codingproblems;

import com.forketyfork.codingproblems.structures.TreeNode;

/**
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 * <p>
 * Two binary trees are considered the same if they are structurally identical, and the nodes have the same
 *
 * @see <a href="https://leetcode.com/problems/same-tree/">LeetCode #100</a>
 */
public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return (p == null && q == null)
                || (p != null && q != null
                && p.val == q.val
                && isSameTree(p.left, q.left)
                && isSameTree(p.right, q.right));
    }
}