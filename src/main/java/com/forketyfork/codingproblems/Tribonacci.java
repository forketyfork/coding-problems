package com.forketyfork.codingproblems;

/**
 * The Tribonacci sequence Tn is defined as follows:
 *
 * T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
 *
 * Given n, return the value of Tn.
 *
 * @see <a href="https://leetcode.com/problems/n-th-tribonacci-number/">LeetCode #1137. N-th Tribonacci Number</a>
 */
class Tribonacci {
    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int[] numbers = new int[38];
        numbers[0] = 0;
        numbers[1] = 1;
        numbers[2] = 1;
        for (int i = 3; i <= n; i++) {
            numbers[i] = numbers[i - 1] + numbers[i - 2] + numbers[i - 3];
        }
        return numbers[n];
    }
}


