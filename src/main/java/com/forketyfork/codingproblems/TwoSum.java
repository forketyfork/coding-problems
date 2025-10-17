package com.forketyfork.codingproblems;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up
 * to target. You may assume that each input would have exactly one solution, and you may not use the same element
 * twice. You can return the answer in any order.
 *
 * @see <a href="https://leetcode.com/problems/two-sum/">LeetCode #1. Two Sum</a>
 * @see TwoSumExists
 */
public class TwoSum {

    /**
     * Finds two numbers in the array that add up to the target.
     * Uses a HashMap for O(1) lookups to achieve linear time complexity.
     *
     * @param nums the array of integers
     * @param target the target sum
     * @return an array containing the indices of the two numbers that add up to target
     *
     * <p>Time Complexity: O(n) where n is the length of the array
     * <p>Space Complexity: O(n) for the HashMap
     *
     * <p>Algorithm: For each element, check if (target - element) exists in the HashMap.
     * If yes, we found our pair. If no, add the current element to the HashMap.
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            // Check if the complement exists
            Integer idx = seen.get(target - value);
            if (idx != null) {
                return new int[] {idx, i};
            }
            // Store current value and its index
            seen.put(value, i);
        }
        throw new AssertionError();
    }

}
