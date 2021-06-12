package com.forketyfork.codingproblems;

import com.forketyfork.codingproblems.structures.RandomPointerListNode;

import static com.forketyfork.codingproblems.structures.RandomPointerListNode.node;

/**
 * A linked list of length n is given such that each node contains an additional random pointer, which could point
 * to any node in the list, or null.
 * <p>
 * Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node
 * has its value set to the value of its corresponding original node. Both the next and random pointer of the new
 * nodes should point to new nodes in the copied list such that the pointers in the original list and copied list
 * represent the same list state. None of the pointers in the new list should point to nodes in the original list.
 * <p>
 * For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding
 * two nodes x and y in the copied list, x.random --> y.
 * <p>
 * Return the head of the copied linked list.
 * <p>
 * The linked list is represented in the input/output as a list of n nodes. Each node is represented as a pair of
 * [val, random_index] where:
 * <p>
 * val: an integer representing Node.val
 * random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null if it does
 * not point to any node.
 * <p>
 * Your code will only be given the head of the original linked list.
 *
 * @see <a href="https://leetcode.com/problems/copy-list-with-random-pointer/">LeetCode #138. Copy List with Random Pointer</a>
 */
class CopyListWithRandomPointer {

    public RandomPointerListNode copyRandomList(RandomPointerListNode head) {

        var p = head;
        while (p != null) {
            var newp = p.next;
            var copy = node(p.val);
            copy.next = p.next;
            p.next = copy;
            p = newp;
        }

        p = head;
        while (p != null) {
            p.next.random = p.random == null ? null : p.random.next;
            p = p.next.next;
        }

        p = head;
        var dummy = node(0);
        var curr = dummy;
        while (p != null) {
            var newp = p.next.next;
            curr.next = p.next;
            curr = curr.next;
            p.next = newp;
            p = newp;
        }
        return dummy.next;
    }
}
