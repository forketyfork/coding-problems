package com.forketyfork.codingproblems;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it can trap after raining.
 *
 * @see <a href="https://leetcode.com/problems/trapping-rain-water/">LeetCode #42. Trapping Rain Water</a>
 */
class TrappingRainWater {

    public int trap(int[] height) {

        if (height.length == 0) {
            return 0;
        }

        int p1 = 0, p2 = height.length - 1;

        int sum = 0;

        int max1 = height[p1], max2 = height[p2];

        while (p1 < p2) {
            if (max1 <= max2) {
                p1++;
                max1 = Math.max(max1, height[p1]);
                sum += Math.max(0, Math.min(max1, max2) - height[p1]);
            }
            else {
                p2--;
                max2 = Math.max(max2, height[p2]);
                sum += Math.max(0, Math.min(max1, max2) - height[p2]);
            }
        }

        return sum;

    }
}