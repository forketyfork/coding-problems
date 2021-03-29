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

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            Integer idx = seen.get(target - value);
            if (idx != null) {
                return new int[] {idx, i};
            }
            seen.put(value, i);
        }
        throw new AssertionError();
    }

}
