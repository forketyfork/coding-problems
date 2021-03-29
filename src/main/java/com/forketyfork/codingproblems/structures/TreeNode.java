package com.forketyfork.codingproblems.structures;

public class TreeNode {

    public TreeNode left;

    public TreeNode right;

    public int val;

    public static TreeNode node(int val, TreeNode left, TreeNode right) {
        var node = new TreeNode();
        node.val = val;
        node.left = left;
        node.right = right;
        return node;
    }

    public static TreeNode node(int val) {
        var node = new TreeNode();
        node.val = val;
        return node;
    }

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
