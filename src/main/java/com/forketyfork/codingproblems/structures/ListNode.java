package com.forketyfork.codingproblems.structures;

/**
 * A singly-linked list node used in various list-based coding problems.
 * Contains an integer value and a pointer to the next node.
 */
public class ListNode {

    public ListNode next;
    public int val;

    /**
     * Creates a new list node with the specified value and next pointer.
     *
     * @param val the integer value for the node
     * @param next the next node in the list (can be null)
     * @return a new ListNode instance
     */
    public static ListNode node(int val, ListNode next) {
        var node = new ListNode();
        node.val = val;
        node.next = next;
        return node;
    }

    /**
     * Creates a new list node with the specified value and null next pointer.
     *
     * @param val the integer value for the node
     * @return a new ListNode instance with null next
     */
    public static ListNode node(int val) {
        var node = new ListNode();
        node.val = val;
        return node;
    }

    /**
     * Creates a linked list from an array of integers.
     * Convenience method for testing and initialization.
     *
     * @param array the values to create the linked list from
     * @return the head of the newly created linked list
     */
    public static ListNode from(int... array) {
        var dummy = new ListNode();
        var current = dummy;
        for (int value : array) {
            current.next = node(value);
            current = current.next;
        }
        return dummy.next;
    }

    /**
     * Checks if two linked lists are equal (same values in same order).
     * Uses recursive comparison.
     *
     * @param object the object to compare with
     * @return true if the lists are equal, false otherwise
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ListNode head2)) {
            return false;
        }
        var head1 = this;
        if (head1.val != head2.val) {
            return false;
        }
        if (head1.next == null && head2.next == null) {
            return true;
        }
        if (head1.next == null || head2.next == null) {
            return false;
        }
        return head1.next.equals(head2.next);
    }

    /**
     * Returns a string representation of the linked list.
     * Format: "[ val1 val2 val3 ... ]"
     *
     * @return string representation of the list
     */
    @Override
    public String toString() {
        var head = this;
        var builder = new StringBuilder("[ ");
        while (head != null) {
            builder.append(head.val).append(' ');
            head = head.next;
        }
        builder.append(']');
        return builder.toString();
    }
}
