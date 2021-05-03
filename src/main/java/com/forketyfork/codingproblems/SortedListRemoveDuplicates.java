package com.forketyfork.codingproblems;

import com.forketyfork.codingproblems.structures.ListNode;

/**
 * Given the head of a sorted linked list, delete all duplicates such that each element appears only once.
 * Return the linked list sorted as well.
 *
 * @see <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-list/">LeetCode #83. Remove Duplicates from Sorted List</a>
 */
class SortedListRemoveDuplicates {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode current = head;
        while (current.next != null) {
            if (current.next.val == current.val) {
                current.next = current.next.next;
            }
            else {
                current = current.next;
            }
        }
        return head;
    }

}
