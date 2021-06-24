package com.forketyfork.codingproblems;

/**
 * You are given a sorted array consisting of only integers where every element appears exactly twice,
 * except for one element which appears exactly once. Find this single element that appears only once.
 * Your solution should run in O(log n) time and O(1) space.
 * <p>
 * Solution: using binary search to find the element. We take the middle element and test whether it has
 * a pair as the previous or the next element. We then narrow the search to the left or to the right of this pair,
 * depending on which of the sizes of adjacent arrays (left or right) is an odd value.
 *
 * @see <a href="https://leetcode.com/problems/single-element-in-a-sorted-array/">LeetCode #540. Single Element in a Sorted Array</a>
 */
public class SingleElementSortedArray {

    public int singleNonDuplicate(int[] nums) {
        int p1 = 0, p2 = nums.length - 1;
        while (p1 < p2) {
            int middle = (p1 + p2) >> 1;
            if (middle > 0 && nums[middle - 1] == nums[middle]) {
                if (((middle - 1 - p1) & 1) == 0) {
                    p1 = middle + 1;
                }
                else {
                    p2 = middle - 2;
                }
            }
            else if (middle < nums.length - 1 && nums[middle + 1] == nums[middle]) {
                if (((middle - p1) & 1) == 0) {
                    p1 = middle + 2;
                }
                else {
                    p2 = middle - 1;
                }
            }
            else {
                p1 = p2 = middle;
            }
        }
        return nums[p1];
    }
}