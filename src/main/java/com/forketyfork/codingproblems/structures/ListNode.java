package com.forketyfork.codingproblems.structures;

public class ListNode {

    public ListNode next;
    public int val;

    public static ListNode node(int val, ListNode next) {
        var node = new ListNode();
        node.val = val;
        node.next = next;
        return node;
    }

    public static ListNode node(int val) {
        var node = new ListNode();
        node.val = val;
        return node;
    }

    public static ListNode from(int... array) {
        var dummy = new ListNode();
        var current = dummy;
        for (int value : array) {
            current.next = node(value);
            current = current.next;
        }
        return dummy.next;
    }

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
