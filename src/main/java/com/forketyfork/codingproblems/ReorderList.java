package com.forketyfork.codingproblems;

import com.forketyfork.codingproblems.structures.ListNode;

/**
 * You are given the head of a singly linked-list. The list can be represented as:
 * <p>
 * L0 → L1 → … → Ln - 1 → Ln
 * <p>
 * Reorder the list to be on the following form:
 * <p>
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * <p>
 * You may not modify the values in the list's nodes. Only nodes themselves may be changed.
 *
 * @see <a href="https://leetcode.com/problems/reorder-list/">LeetCode #143. Reorder List</a>
 */
public class ReorderList {

    public void reorderList(ListNode head) {

        // calculate the length of the list
        int length = 0;
        var p = head;
        while (p != null) {
            length++;
            p = p.next;
        }

        // divide the list into two parts: find the last element in the first list
        p = head;
        int endOfFirstList = (length >> 1) - 1;
        for (int i = 0; i < endOfFirstList; i++) {
            p = p.next;
        }

        // find the first element in the second list and disconnect the first list from the second
        ListNode p2 = p.next;
        p.next = null;

        // reverse the second list
        ListNode prev = null;
        while (p2 != null) {
            var curr = p2;
            var next = p2.next;
            curr.next = prev;
            prev = curr;
            p2 = next;
        }
        p2 = prev;

        // merge the two lists alternating
        var p1 = head;
        while (p1 != null && p2 != null) {
            var nextp1 = p1.next;
            var nextp2 = p2.next;
            p1.next = p2;
            p2.next = nextp1 == null ? nextp2 : nextp1;
            p1 = nextp1;
            p2 = nextp2;
        }

    }
}