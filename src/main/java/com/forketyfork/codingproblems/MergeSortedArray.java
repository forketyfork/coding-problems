package com.forketyfork.codingproblems;

/**
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n,
 * representing the number of elements in nums1 and nums2 respectively.
 * <p>
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 * <p>
 * The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
 * To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be
 * merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 *
 * @see <a href="https://leetcode.com/problems/merge-sorted-array/">LeetCode #88. Merge Sorted Array</a>
 */
public class MergeSortedArray {

    /**
     * Merges two sorted arrays into one sorted array in-place.
     * Works backwards from the end to avoid overwriting elements in nums1.
     *
     * @param nums1 the first sorted array with size m+n (first m elements are valid, last n are zeros)
     * @param m the number of valid elements in nums1
     * @param nums2 the second sorted array with size n
     * @param n the number of elements in nums2
     *
     * <p>Time Complexity: O(m + n) where m and n are the sizes of the two arrays
     * <p>Space Complexity: O(1) - merges in-place without extra space
     *
     * <p>Algorithm: Use three pointers - p1 (end of valid nums1), p2 (end of nums2),
     * and p (end of merged array). Fill from right to left, always picking the larger element.
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1;
        int p = nums1.length - 1;
        while (p1 >= 0 || p2 >= 0) {
            int el;
            if (p1 == -1) {
                // All nums1 elements processed, take from nums2
                el = nums2[p2--];
            }
            else if (p2 == -1) {
                // All nums2 elements processed, take from nums1
                el = nums1[p1--];
            }
            else {
                // Compare and take the larger element
                int e1 = nums1[p1], e2 = nums2[p2];
                if (e1 >= e2) {
                    el = e1;
                    p1--;
                }
                else {
                    el = e2;
                    p2--;
                }
            }
            nums1[p--] = el;
        }
    }

}
