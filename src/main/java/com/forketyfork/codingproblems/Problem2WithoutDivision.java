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

    public int[] calculate(int[] array) {
        int[] result = new int[array.length];
        int mul = 1;
        for (int i = 0; i < array.length; i++) {
            result[i] = mul;
            mul *= array[i];
        }
        mul = 1;
        for (int i = array.length - 1; i >= 0; i--) {
            result[i] *= mul;
            mul *= array[i];
        }
        return result;
    }

}
