package com.forketyfork.codingproblems;

import java.util.HashSet;
import java.util.Set;

/**
 * This problem was asked by Microsoft.
 * <p>
 * Given an array of numbers and a number k, determine if there are three entries in the array
 * which add up to the specified number k. For example, given [20, 303, 3, 4, 25] and k = 49,
 * return true as 20 + 4 + 25 = 49.
 *
 * @see "Daily Coding Problem #339"
 */
public class Problem339 {

    /**
     * Determines if there are three entries in the array that add up to the specified sum k.
     * The algorithm reduces the 3-sum problem to multiple 2-sum problems by fixing one element
     * at a time and searching for two other elements that sum to the remaining target.
     *
     * @param array the input array of integers
     * @param k the target sum
     * @return true if three elements exist that sum to k, false otherwise
     *
     * <p>Time Complexity: O(n^2) where n is the length of the array
     * <p>Space Complexity: O(n) for the HashSet used in the 2-sum subroutine
     */
    public boolean sum3(int[] array, int k) {
        if (array.length < 3) {
            return false;
        }
        // Fix each element and look for a 2-sum in the remaining elements
        for (int i = 0; i < array.length; i++) {
            int diff = k - array[i];
            if (sum2(array, diff, i)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Helper method that determines if two elements in the array (excluding the element
     * at excludeIdx) sum to k. Uses a HashSet to achieve linear time complexity.
     *
     * @param array the input array of integers
     * @param k the target sum for two elements
     * @param excludeIdx the index to exclude from consideration
     * @return true if two elements (excluding excludeIdx) sum to k, false otherwise
     *
     * <p>Time Complexity: O(n) where n is the length of the array
     * <p>Space Complexity: O(n) for the HashSet
     */
    private boolean sum2(int[] array, int k, int excludeIdx) {
        Set<Integer> seen = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            if (i == excludeIdx) {
                continue;
            }
            // Check if the complement exists in the set
            if (seen.contains(k - array[i])) {
                return true;
            }
            seen.add(array[i]);
        }
        return false;
    }

}
