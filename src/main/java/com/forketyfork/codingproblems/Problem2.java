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
public class Problem2 {

    /**
     * Calculates the product of all elements except the one at each index using division.
     * This solution computes the total product of all elements, then divides by each element
     * to get the result at that index.
     *
     * @param array the input array of integers
     * @return a new array where each element at index i is the product of all elements except array[i]
     *
     * <p>Time Complexity: O(n) where n is the length of the array
     * <p>Space Complexity: O(n) for the result array (O(1) auxiliary space)
     *
     * <p>Note: This approach assumes no zero values in the input array. If the array contains
     * zeros, this method will throw an ArithmeticException when dividing by zero.
     */
    public int[] calculate(int[] array) {
        int[] result = new int[array.length];
        // Calculate the product of all elements
        int mul = 1;
        for (int value : array) {
            mul *= value;
        }
        // For each position, divide the total product by the element at that position
        for (int i = 0; i < array.length; i++) {
            result[i] = mul / array[i];
        }
        return result;
    }

}
