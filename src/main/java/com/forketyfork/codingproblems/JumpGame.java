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
 */
public class JumpGame {

    public boolean canJump(int[] nums) {
        int closest = nums.length - 1;
        for (int i = closest - 1; i >= 0; i--) {
            if (i + nums[i] >= closest) {
                closest = i;
            }
        }
        return closest == 0;
    }

}
