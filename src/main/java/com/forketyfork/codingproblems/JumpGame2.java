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

    public int jump(int[] nums) {

        // if the array is empty or only has one element, we don't need to jump at all
        if (nums.length <= 1) {
            return 0;
        }

        // cache[i] - how many steps do you need to get to the last element from the element i.
        // Initialized with -1, which means that this value is not yet calculated.
        // The last element is initialized with 0, as it takes 0 jumps to get to the last element from itself.
        int[] cache = new int[nums.length];
        Arrays.fill(cache, -1);
        cache[cache.length - 1] = 0;

        return jump(nums, cache, 0);
    }

    private int jump(int[] nums, int[] cache, int start) {
        // check if we already calculated the step value for this element
        if (cache[start] == -1) {
            cache[start] = calculateSteps(nums, cache, start);
        }
        return cache[start];
    }

    private int calculateSteps(int[] nums, int[] cache, int start) {
        int jumpSize = nums[start];
        // if we can immediately jump to the last element from this one, return 1
        if (start + jumpSize >= nums.length - 1) {
            return 1;
        }
        else {
            int steps = Integer.MAX_VALUE;
            // find the minimum jump path from all elements that are reachable from the current one
            for (int i = 1; i <= jumpSize; i++) {
                steps = Math.min(steps, jump(nums, cache, start + i));
            }
            // If there is a path, adding 1 to it (jump from the current element),
            // otherwise return max value, meaning there's no path.
            if (steps != Integer.MAX_VALUE) {
                steps++;
            }
            return steps;
        }
    }

}
