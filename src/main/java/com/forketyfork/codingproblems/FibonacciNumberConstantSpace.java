package com.forketyfork.codingproblems;

/**
 * The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number
 * is the sum of the two preceding ones, starting from 0 and 1. That is,
 *
 * <ul>
 * <li>F(0) = 0, F(1) = 1
 * <li>F(n) = F(n - 1) + F(n - 2), for n > 1.
 * </ul>
 * Given n, calculate F(n).
 * <p>
 * This problem was asked by Apple: implement the function fib(n), which returns the nth number in the Fibonacci
 * sequence, using only O(1) space.
 *
 * @see "Daily Coding Problem #233"
 * @see <a href="https://leetcode.com/problems/fibonacci-number/">LeetCode #509. Fibonacci Number</a>
 */
public class FibonacciNumberConstantSpace {

    /**
     * Calculates the nth Fibonacci number using an iterative approach with O(1) space.
     * Instead of storing all previous Fibonacci numbers, only the last two are kept.
     *
     * @param n the index of the Fibonacci number to calculate (0-indexed)
     * @return the nth Fibonacci number
     *
     * <p>Time Complexity: O(n)
     * <p>Space Complexity: O(1) - only uses two variables regardless of n
     *
     * <p>This satisfies the constraint of using only O(1) space, unlike recursive
     * or memoization approaches which use O(n) space.
     */
    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        // Keep track of only the last two Fibonacci numbers
        int n1 = 0;  // F(i-2)
        int n2 = 1;  // F(i-1)
        for (int i = 2; i <= n; i++) {
            int next = n1 + n2;  // F(i) = F(i-1) + F(i-2)
            n1 = n2;  // Shift: F(i-2) becomes F(i-1)
            n2 = next;  // Shift: F(i-1) becomes F(i)
        }
        return n2;
    }

}
