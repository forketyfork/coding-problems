package com.forketyfork.codingproblems;

/**
 * <h1>Problem</h1>
 * <p>
 * Given an array of non-negative integers nums, you are initially positioned at the first index of the array. Each
 * element in the array represents your maximum jump length at that position. Determine if you are able to reach
 * the last index.
 * <p>
 * <h1>Solution</h1>
 * <p>
 * We go through the array right to left. Suppose we've found out that there's a jump path from some element i
 * to the end. Then for the element i-1, we only need to check if we can jump to the closest element to the right
 * that has a jump path to the end (which is currently element i). If we can, then i-1 becomes the next closest element.
 * If we can't, we continue iteration to the left. If at the end of iteration the closest element is 0, then the
 * condition is satisfied.
 *
 * @see <a href="https://leetcode.com/problems/jump-game/">LeetCode #55. Jump Game</a>
 * @see "Daily Coding Problem #512"
 * @see "Daily Coding Problem #565"
 */
public class JumpGame {

    /**
     * Determines if it's possible to jump from the first index to the last index.
     * Uses a greedy approach working backwards from the end.
     *
     * @param nums array where nums[i] represents the maximum jump length from index i
     * @return true if the last index can be reached, false otherwise
     *
     * <p>Time Complexity: O(n) where n is the length of the array
     * <p>Space Complexity: O(1)
     *
     * <p>Algorithm: Work right to left. Track the closest position from which we know
     * we can reach the end. For each position i, check if we can jump to that closest position.
     * If yes, update closest to i. If closest reaches 0, we can jump from start to end.
     */
    public boolean canJump(int[] nums) {
        int closest = nums.length - 1;  // Closest position from which we can reach the end
        for (int i = closest - 1; i >= 0; i--) {
            // If from position i we can reach or pass the closest reachable position
            if (i + nums[i] >= closest) {
                closest = i;  // Update: we can now reach the end from position i
            }
        }
        return closest == 0;  // Check if we can reach the end from the start
    }

}
