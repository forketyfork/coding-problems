package com.forketyfork.codingproblems.structures;

/**
 * A linked list node with an additional random pointer.
 * Used in problems involving deep copying of complex linked list structures.
 */
public class RandomPointerListNode {

    public RandomPointerListNode next;
    public int val;
    public RandomPointerListNode random;

    /**
     * Creates a new node with value, next pointer, and random pointer.
     *
     * @param val the integer value for the node
     * @param next the next node in the list (can be null)
     * @param random a random pointer to any node in the list (can be null)
     * @return a new RandomPointerListNode instance
     */
    public static RandomPointerListNode node(int val, RandomPointerListNode next, RandomPointerListNode random) {
        var node = new RandomPointerListNode();
        node.val = val;
        node.next = next;
        node.random = random;
        return node;
    }

    /**
     * Creates a new node with just a value (null next and random pointers).
     *
     * @param val the integer value for the node
     * @return a new RandomPointerListNode instance
     */
    public static RandomPointerListNode node(int val) {
        var node = new RandomPointerListNode();
        node.val = val;
        return node;
    }

    /**
     * Creates a linked list from an array of integers (without random pointers).
     * Convenience method for testing and initialization.
     *
     * @param array the values to create the linked list from
     * @return the head of the newly created linked list
     */
    public static RandomPointerListNode from(int... array) {
        var dummy = new RandomPointerListNode();
        var current = dummy;
        for (int value : array) {
            current.next = node(value);
            current = current.next;
        }
        return dummy.next;
    }

    /**
     * Checks if two linked lists with random pointers are equal.
     * Compares both the sequential structure and random pointer relationships.
     *
     * @param object the object to compare with
     * @return true if the lists are equal, false otherwise
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof RandomPointerListNode head2)) {
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
        if (head1.random == null && head2.random == null) {
            return true;
        }
        if (head1.random == null || head2.random == null) {
            return false;
        }
        return head1.next.equals(head2.next) && head1.random.equals(head2.random);
    }

    /**
     * Returns a string representation of the linked list (sequential values only).
     * Format: "[ val1 val2 val3 ... ]"
     * Note: Random pointers are not shown in this representation.
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
