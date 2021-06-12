package com.forketyfork.codingproblems.structures;

public class RandomPointerListNode {

    public RandomPointerListNode next;
    public int val;
    public RandomPointerListNode random;

    public static RandomPointerListNode node(int val, RandomPointerListNode next, RandomPointerListNode random) {
        var node = new RandomPointerListNode();
        node.val = val;
        node.next = next;
        node.random = random;
        return node;
    }

    public static RandomPointerListNode node(int val) {
        var node = new RandomPointerListNode();
        node.val = val;
        return node;
    }

    public static RandomPointerListNode from(int... array) {
        var dummy = new RandomPointerListNode();
        var current = dummy;
        for (int value : array) {
            current.next = node(value);
            current = current.next;
        }
        return dummy.next;
    }

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
