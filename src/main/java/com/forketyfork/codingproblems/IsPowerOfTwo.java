package com.forketyfork.codingproblems;

/**
 * Given an integer n, return true if it is a power of two. Otherwise, return false.
 * <p>
 * An integer n is a power of two, if there exists an integer x such that n == 2x.
 * <p>
 * Solution: count the amount of set bits in the integer. For the powers of two, it should be 1.
 * The loop condition also allows us to treat non-positive values.
 *
 * @see <a href="https://leetcode.com/problems/power-of-two/">LeetCode #231. Power of Two</a>
 */
public class IsPowerOfTwo {

    public boolean isPowerOfTwo(int n) {
        int setBitCount = 0;
        while (n > 0) {
            setBitCount += (n & 1);
            n >>= 1;
        }
        return setBitCount == 1;
    }
}