package com.forketyfork.codingproblems;

/**
 * Given an array of integers, find the first missing positive integer in linear time and constant space.
 * In other words, find the lowest positive integer that does not exist in the array.
 * The array can contain duplicates and negative numbers as well.
 * <p>
 * For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.
 * <p>
 * You can modify the input array in-place.
 *
 * @see "Daily Coding Problem #4"
 */
public class Problem4 {

    /**
     * Finds the first missing positive integer in the array using in-place cyclic sort.
     * The algorithm places each positive integer k (where 1 <= k <= n) at index k-1,
     * then scans for the first position that doesn't contain the expected value.
     *
     * @param array the input array (will be modified in-place)
     * @return the smallest positive integer (>= 1) that is not present in the array
     *
     * <p>Time Complexity: O(n) where n is the length of the array. Although there's a nested
     * while loop, each element is placed in its correct position at most once, so the total
     * number of swaps is bounded by n.
     * <p>Space Complexity: O(1) - the algorithm modifies the input array in-place
     *
     * <p>Algorithm:
     * 1. For each position, attempt to place the value at its "correct" index (value-1)
     * 2. Chain the displaced values to their correct positions
     * 3. Scan the array to find the first missing positive integer
     */
    public int calculate(int[] array) {
        // Phase 1: Place each positive integer at its correct position
        for (int i = 0; i < array.length; i++) {
            int value = array[i];
            array[i] = 0;
            // Chain placement: keep moving values to their correct positions
            while (value > 0 && value <= array.length && array[value - 1] != value) {
                int newValue = array[value - 1];
                array[value - 1] = value;
                value = newValue;
            }
        }

        // Phase 2: Find the first missing positive integer
        for (int i = 0; i < array.length; i++) {
            if (array[i] <= 0) {
                return i + 1;
            }
        }
        // If all positions 1..n are filled, return n+1
        return array.length + 1;
    }

}
