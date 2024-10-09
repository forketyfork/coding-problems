package com.forketyfork.codingproblems;

import java.util.HashMap;
import java.util.Map;

/**
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 * <p>
 * Implement the LRUCache class:
 * <p>
 * LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 * int get(int key) Return the value of the key if the key exists, otherwise return -1.
 * void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair
 * to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
 * The functions get and put must each run in O(1) average time complexity.
 * <p>
 * * @see <a href="https://leetcode.com/problems/lru-cache/">LeetCode #146. LRU Cache</a>
 */
public class LRUCache {

    static class Node {

        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value, Node prev, Node next) {
            this.key = key;
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }

    private final int capacity;
    private int size = 0;
    private final Node head = new Node(0, 0, null, null);
    private Node tail = head;

    private final Map<Integer, Node> index = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public void put(int key, int value) {
        // if a node exists, just bump it and update its value
        Node existingNode = getNode(key);
        if (existingNode != null) {
            existingNode.value = value;
            return;
        }
        if (size == capacity) {
            // pop the node from the beginning of the list
            Node removedNode = head.next;
            head.next = removedNode.next;
            if (head.next != null) {
                head.next.prev = head;
            }
            index.remove(removedNode.key);
        }
        else {
            size++;
        }

        var newNode = new Node(key, value, tail, null);
        tail.next = newNode;
        tail = newNode;
        index.put(key, newNode);
    }

    public int get(int key) {
        Node node = getNode(key);
        if (node == null) {
            return -1;
        }
        return node.value;
    }

    private Node getNode(int key) {
        Node node = index.get(key);
        if (node != null && node.next != null) {
            // bump the node to the front of the list
            node.prev.next = node.next;
            node.next.prev = node.prev;
            tail.next = node;
            node.prev = tail;
            node.next = null;
            tail = node;
        }
        return node;
    }

}

