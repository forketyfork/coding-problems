package com.forketyfork.codingproblems;

import java.util.HashSet;

/**
 * Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
 * <p>
 * For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
 * <p>
 * Bonus: Can you do this in one pass?
 *
 * @see "Daily Coding Problem #1"
 * @see TwoSum
 */
public class TwoSumExists {

    /**
     * Checks if any two numbers in the array add up to the target in a single pass.
     * Uses a HashSet to track seen values for O(1) lookups.
     *
     * @param target the target sum
     * @param array the array of integers
     * @return true if two numbers add up to target, false otherwise
     *
     * <p>Time Complexity: O(n) where n is the length of the array
     * <p>Space Complexity: O(n) for the HashSet
     *
     * <p>This is the bonus solution that does it in one pass.
     */
    public boolean check(int target, int[] array) {
        var seen = new HashSet<Integer>();
        for (int value : array) {
            // Check if the complement (target - value) has been seen
            if (seen.contains(target - value)) {
                return true;
            }
            seen.add(value);
        }
        return false;
    }

}
