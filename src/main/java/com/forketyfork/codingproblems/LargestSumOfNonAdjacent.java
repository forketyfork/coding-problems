package com.forketyfork.codingproblems;

/**
 * <h1>Problem</h1>
 * <p>
 * Given a list of integers, write a function that returns the largest sum of non-adjacent numbers.
 * Numbers can be 0 or negative.
 * <p>
 * Follow-up: Can you do this in O(N) time and constant space?
 * <p>
 * <h1>Solution</h1>
 * We traverse the array from left to right. At every step, we find the maximum of three values:
 * <ul>
 *     <li>The maximum value found on n-1 step (max)</li>
 *     <li>The value of the current element (value) </li>
 *     <li>The sum of the value found on n-2 step plus the value of the current element (prevmax + value)</li>
 * </ul>
 * Longs are used during the calculation to prevent integer overflow.
 * The solution has O(1) memory complexity and O(n) time complexity.
 *
 * @see "Daily Coding Problem #564"
 */
public class LargestSumOfNonAdjacent {

    public int largestSumOfNonAdjacent(int[] array) {
        long prevmax = Integer.MIN_VALUE;
        long max = Integer.MIN_VALUE;

        for (int value : array) {
            long newmax = maxOfThree(value, max, prevmax + value);
            prevmax = max;
            max = newmax;
        }
        return (int) max;
    }

    private long maxOfThree(long i1, long i2, long i3) {
        return Math.max(i1, Math.max(i2, i3));
    }

}
