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

    public int calculate(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int value = array[i];
            array[i] = 0;
            while (value > 0 && value <= array.length && array[value - 1] != value) {
                int newValue = array[value - 1];
                array[value - 1] = value;
                value = newValue;
            }
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] <= 0) {
                return i + 1;
            }
        }
        return array.length + 1;
    }

}
