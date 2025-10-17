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

    /**
     * Finds the largest sum of non-adjacent numbers in an array using dynamic programming.
     * For each element, we decide whether to include it or not based on maximum achievable sum.
     *
     * @param array the input array of integers (can contain 0 or negative values)
     * @return the largest sum of non-adjacent numbers
     *
     * <p>Time Complexity: O(n) where n is the length of the array
     * <p>Space Complexity: O(1) - only uses two variables to track previous states
     *
     * <p>Algorithm: At each position, the maximum sum is either:
     * 1. The current element value alone
     * 2. The max from previous position (excluding current)
     * 3. Max from two positions back plus current element
     * Uses long to prevent integer overflow during calculations.
     */
    public int largestSumOfNonAdjacent(int[] array) {
        long prevmax = Integer.MIN_VALUE;  // Max sum ending 2 positions ago
        long max = Integer.MIN_VALUE;  // Max sum ending 1 position ago

        for (int value : array) {
            // Consider three options for current position
            long newmax = maxOfThree(value, max, prevmax + value);
            prevmax = max;
            max = newmax;
        }
        return (int) max;
    }

    /**
     * Returns the maximum of three long values.
     *
     * @param i1 first value
     * @param i2 second value
     * @param i3 third value
     * @return the maximum of the three values
     */
    private long maxOfThree(long i1, long i2, long i3) {
        return Math.max(i1, Math.max(i2, i3));
    }

}
