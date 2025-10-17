package com.forketyfork.codingproblems.structures;

/**
 * A binary tree node used in various tree-based coding problems.
 * Contains an integer value and pointers to left and right children.
 */
public class TreeNode {

    public TreeNode left;

    public TreeNode right;

    public int val;

    /**
     * Creates a new tree node with the specified value and children.
     *
     * @param val the integer value for the node
     * @param left the left child node (can be null)
     * @param right the right child node (can be null)
     * @return a new TreeNode instance
     */
    public static TreeNode node(int val, TreeNode left, TreeNode right) {
        var node = new TreeNode();
        node.val = val;
        node.left = left;
        node.right = right;
        return node;
    }

    /**
     * Creates a new tree node with the specified value and no children.
     *
     * @param val the integer value for the node
     * @return a new TreeNode instance with null left and right children
     */
    public static TreeNode node(int val) {
        var node = new TreeNode();
        node.val = val;
        return node;
    }

    /**
     * Checks if two binary trees are structurally identical and have the same node values.
     * Uses recursive comparison of the tree structure and values.
     *
     * @param object the object to compare with
     * @return true if the trees are equal, false otherwise
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof TreeNode head2)) {
            return false;
        }
        var head1 = this;
        if (head1.val != head2.val) {
            return false;
        }
        if (head1.left == null && head2.left != null || head1.left != null && head2.left == null) {
            return false;
        }
        if (head1.right == null && head2.right != null || head1.right != null && head2.right == null) {
            return false;
        }
        return ((head1.left == null || head1.left.equals(head2.left))
                && (head1.right == null || head1.right.equals(head2.right)));
    }

}
