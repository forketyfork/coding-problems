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

    /**
     * Internal doubly-linked list node used to maintain access order.
     * The most recently used nodes are kept at the tail of the list.
     */
    static class Node {

        int key;
        int value;
        Node prev;
        Node next;

        /**
         * Creates a new node with the specified key-value pair and links.
         *
         * @param key the cache key
         * @param value the cache value
         * @param prev the previous node in the list
         * @param next the next node in the list
         */
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

    /**
     * Initializes the LRU cache with the specified capacity.
     * The cache uses a HashMap for O(1) lookups and a doubly-linked list for O(1) eviction.
     *
     * @param capacity the maximum number of key-value pairs the cache can hold (must be positive)
     *
     * <p>Time Complexity: O(1)
     * <p>Space Complexity: O(1)
     */
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Inserts or updates a key-value pair in the cache. If the key already exists,
     * its value is updated and it's marked as most recently used. If the cache is
     * at capacity, the least recently used item is evicted before insertion.
     *
     * @param key the key to insert or update
     * @param value the value to associate with the key
     *
     * <p>Time Complexity: O(1) average case (HashMap operations)
     * <p>Space Complexity: O(1)
     */
    public void put(int key, int value) {
        // If a node exists, bump it to the end (most recent) and update its value
        Node existingNode = getNode(key);
        if (existingNode != null) {
            existingNode.value = value;
            return;
        }
        if (size == capacity) {
            // Evict the least recently used node (first node after head)
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

        // Add new node at the tail (most recently used position)
        var newNode = new Node(key, value, tail, null);
        tail.next = newNode;
        tail = newNode;
        index.put(key, newNode);
    }

    /**
     * Retrieves the value associated with the given key. If the key exists,
     * it's marked as most recently used by moving it to the tail of the list.
     *
     * @param key the key to look up
     * @return the value associated with the key, or -1 if the key doesn't exist
     *
     * <p>Time Complexity: O(1) average case (HashMap lookup)
     * <p>Space Complexity: O(1)
     */
    public int get(int key) {
        Node node = getNode(key);
        if (node == null) {
            return -1;
        }
        return node.value;
    }

    /**
     * Internal helper method that retrieves a node and moves it to the tail
     * (most recently used position) if it's not already there.
     *
     * @param key the key to look up
     * @return the node associated with the key, or null if not found
     */
    private Node getNode(int key) {
        Node node = index.get(key);
        if (node != null && node.next != null) {
            // Move the node to the tail (most recently used position)
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

