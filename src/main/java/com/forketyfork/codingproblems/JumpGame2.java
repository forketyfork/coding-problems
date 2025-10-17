package com.forketyfork.codingproblems;

import java.util.Arrays;

/**
 * Given an array of non-negative integers nums, you are initially positioned at the first index of the array. Each
 * element in the array represents your maximum jump length at that position. Your goal is to reach the last index
 * in the minimum number of jumps. You can assume that you can always reach the last index.
 *
 * @see <a href="https://leetcode.com/problems/jump-game-ii/">LeetCode #45. Jump Game II</a>
 * @see "Daily Coding Problem #511"
 * @see <a href="https://www.geeksforgeeks.org/minimum-number-of-jumps-to-reach-end-of-a-given-array/">Minimum number of jumps to reach end</a>
 */
public class JumpGame2 {

    /**
     * Finds the minimum number of jumps needed to reach the last index.
     * Uses dynamic programming with memoization to avoid redundant calculations.
     *
     * @param nums array where nums[i] represents the maximum jump length from index i
     * @return the minimum number of jumps to reach the last index
     *
     * <p>Time Complexity: O(n * max_jump) where n is array length and max_jump is the maximum jump value
     * <p>Space Complexity: O(n) for the memoization cache
     *
     * <p>Algorithm: Build a cache where cache[i] stores the minimum jumps needed from index i to the end.
     * For each position, try all possible jumps and select the one requiring minimum total jumps.
     */
    public int jump(int[] nums) {

        // If the array is empty or only has one element, we don't need to jump at all
        if (nums.length <= 1) {
            return 0;
        }

        // cache[i] - minimum number of jumps needed to reach the end from index i
        // Initialized with -1, which means this value hasn't been calculated yet
        // The last element is initialized with 0 (no jumps needed from last to last)
        int[] cache = new int[nums.length];
        Arrays.fill(cache, -1);
        cache[cache.length - 1] = 0;

        return jump(nums, cache, 0);
    }

    /**
     * Helper method that retrieves the minimum jumps from cache or calculates it.
     *
     * @param nums the input array
     * @param cache the memoization cache
     * @param start the starting index
     * @return the minimum number of jumps from start to the end
     */
    private int jump(int[] nums, int[] cache, int start) {
        // Check if we already calculated the step value for this element
        if (cache[start] == -1) {
            cache[start] = calculateSteps(nums, cache, start);
        }
        return cache[start];
    }

    /**
     * Calculates the minimum number of jumps from a given position to the end.
     *
     * @param nums the input array
     * @param cache the memoization cache
     * @param start the starting index
     * @return the minimum number of jumps from start to the end
     */
    private int calculateSteps(int[] nums, int[] cache, int start) {
        int jumpSize = nums[start];
        // If we can immediately jump to or past the last element, return 1
        if (start + jumpSize >= nums.length - 1) {
            return 1;
        }
        else {
            int steps = Integer.MAX_VALUE;
            // Find the minimum jump path from all positions reachable from current one
            for (int i = 1; i <= jumpSize; i++) {
                steps = Math.min(steps, jump(nums, cache, start + i));
            }
            // If there is a valid path, add 1 for the current jump
            // Otherwise return MAX_VALUE to indicate no path exists
            if (steps != Integer.MAX_VALUE) {
                steps++;
            }
            return steps;
        }
    }

}
