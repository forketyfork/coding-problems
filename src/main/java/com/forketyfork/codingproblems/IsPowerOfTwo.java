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

    /**
     * Determines if an integer is a power of two by counting set bits.
     * A number is a power of two if and only if it has exactly one bit set in its binary representation.
     *
     * @param n the integer to check
     * @return true if n is a power of two, false otherwise
     *
     * <p>Time Complexity: O(log n) where n is the input value (number of bits)
     * <p>Space Complexity: O(1)
     *
     * <p>Note: This handles non-positive values correctly as the loop condition is n > 0.
     * An alternative O(1) solution would be: n > 0 && (n & (n - 1)) == 0
     */
    public boolean isPowerOfTwo(int n) {
        int setBitCount = 0;
        while (n > 0) {
            setBitCount += (n & 1);  // Add 1 if the least significant bit is set
            n >>= 1;  // Shift right to check the next bit
        }
        return setBitCount == 1;
    }
}