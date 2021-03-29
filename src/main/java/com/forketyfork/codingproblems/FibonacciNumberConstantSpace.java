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

    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        int n1 = 0;
        int n2 = 1;
        for (int i = 2; i <= n; i++) {
            int next = n1 + n2;
            n1 = n2;
            n2 = next;
        }
        return n2;
    }

}
