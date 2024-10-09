package com.forketyfork.codingproblems;

import com.forketyfork.codingproblems.structures.ListNode;

/**
 * This problem was asked by Airbnb.
 *
 * Given a linked list and a positive integer k, rotate the list to the right by k places.
 *
 * For example, given the linked list 7 -> 7 -> 3 -> 5 and k = 2, it should become 3 -> 5 -> 7 -> 7.
 *
 * Given the linked list 1 -> 2 -> 3 -> 4 -> 5 and k = 3, it should become 3 -> 4 -> 5 -> 1 -> 2.
 *
 * @see Daily Coding Problem #927
 */
public class RotateLinkedList {

    public ListNode rotate(ListNode list, int k) {
        if (k == 0 || list == null) {
            return list;
        }
        ListNode head = list;
        ListNode curr = head;
        int len = 1;
        while (curr.next != null) {
            curr = curr.next;
            len++;
        }
        ListNode last = curr;
        k %= len;
        curr = head;
        for (int i = 0; i < len - k - 1; i++) {
            curr = curr.next;
        }
        last.next = head;
        head = curr.next;
        curr.next = null;
        return head;
    }

}
