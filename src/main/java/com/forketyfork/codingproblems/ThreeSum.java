package com.forketyfork.codingproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that
 * i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * The solution set must not contain duplicate triplets.
 *
 * @see <a href="https://leetcode.com/problems/3sum/">LeetCode #15. 3Sum</a>
 */
public class ThreeSum {

    /**
     * Finds all unique triplets in the array that sum to zero.
     * Uses sorting and two-pointer technique to achieve O(n^2) complexity.
     *
     * @param nums the input array of integers
     * @return a list of all unique triplets that sum to zero
     *
     * <p>Time Complexity: O(n^2) where n is the length of the array
     * <p>Space Complexity: O(1) auxiliary space (excluding output), O(log n) for sorting
     *
     * <p>Algorithm:
     * 1. Sort the array
     * 2. Fix the first element and use two pointers for the remaining two
     * 3. Skip duplicates to avoid duplicate triplets
     */
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int num1 = nums[i];
            // If first number > 0, no triplets sum to 0 (array is sorted)
            if (num1 > 0) {
                break;
            }
            // Skip duplicate first elements
            if (i > 0 && num1 == nums[i - 1]) {
                continue;
            }

            // Look for two numbers that sum to -num1
            int sum = -num1;

            int lo = i + 1, hi = nums.length - 1;

            // Two-pointer approach
            while (lo < hi) {
                int num2 = nums[lo], num3 = nums[hi];
                int currSum = num2 + num3;
                if (currSum == sum) {
                    // Found a triplet
                    result.add(List.of(num1, num2, num3));
                    // Skip duplicates
                    while (lo < hi && nums[lo] == num2) {
                        lo++;
                    }
                    while (lo < hi && nums[hi] == num3) {
                        hi--;
                    }
                }
                else if (currSum > sum) {
                    // Sum too large, move right pointer left
                    while (lo < hi && nums[hi] == num3) {
                        hi--;
                    }
                }
                else {
                    // Sum too small, move left pointer right
                    while (lo < hi && nums[lo] == num2) {
                        lo++;
                    }
                }
            }

        }

        return result;
    }
}
