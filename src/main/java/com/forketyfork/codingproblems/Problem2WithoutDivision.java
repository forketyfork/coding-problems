package com.forketyfork.codingproblems;

/**
 * This problem was asked by Uber.
 * <p>
 * Given an array of integers, return a new array such that each element at index i of the new array is the product of
 * all the numbers in the original array except the one at i.
 * <p>
 * For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was
 * [3, 2, 1], the expected output would be [2, 3, 6].
 * <p>
 * Follow-up: what if you can't use division?
 *
 * @see "Daily Coding Problem #2"
 */
public class Problem2WithoutDivision {

    /**
     * Calculates the product of all elements except the one at each index WITHOUT using division.
     * This solution uses two passes: a forward pass to accumulate products of all elements
     * to the left, and a backward pass to multiply by products of all elements to the right.
     *
     * @param array the input array of integers
     * @return a new array where each element at index i is the product of all elements except array[i]
     *
     * <p>Time Complexity: O(n) where n is the length of the array
     * <p>Space Complexity: O(n) for the result array (O(1) auxiliary space)
     *
     * <p>Algorithm:
     * 1. Forward pass: result[i] = product of all elements before i
     * 2. Backward pass: result[i] *= product of all elements after i
     * This gives result[i] = product of all elements except array[i]
     */
    public int[] calculate(int[] array) {
        int[] result = new int[array.length];
        // Forward pass: accumulate products of elements to the left
        int mul = 1;
        for (int i = 0; i < array.length; i++) {
            result[i] = mul;
            mul *= array[i];
        }
        // Backward pass: multiply by products of elements to the right
        mul = 1;
        for (int i = array.length - 1; i >= 0; i--) {
            result[i] *= mul;
            mul *= array[i];
        }
        return result;
    }

}
