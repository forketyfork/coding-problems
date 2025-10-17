package com.forketyfork.codingproblems;

/**
 * You are given an array target of n integers. From a starting array arr consisting of n 1's,
 * you may perform the following procedure repeatedly:
 * <ul>
 * <li>let x be the sum of all elements currently in your array.</li>
 * <li>choose index i, such that 0 <= i < n and set the value of arr at index i to x.</li>
 * <li>you may repeat this procedure as many times as needed.</li>
 * </ul>
 * Return true if it is possible to construct the target array from arr, otherwise, return false.
 *
 * @see <a href="https://leetcode.com/problems/construct-target-array-with-multiple-sums/">LeetCode #1354. Construct Target Array With Multiple Sums</a>
 */
class ConstructTargetArrayWithMultipleSums {

    /**
     * Determines if the target array can be constructed by starting from an array of all 1's
     * and repeatedly replacing elements with the sum of all elements. This solution works
     * backwards from the target array using a max heap to efficiently find the largest element.
     *
     * @param target the target array to check
     * @return true if the target array can be constructed, false otherwise
     *
     * <p>Time Complexity: O(n * log(max_value)) where n is the array length
     * <p>Space Complexity: O(1) - the heap is built in-place
     *
     * <p>Algorithm: Work backwards from target to [1,1,...,1] by repeatedly:
     * 1. Finding the max element (using a max heap)
     * 2. Computing what it must have been before the last operation
     * 3. Checking if the reconstruction is valid
     */
    public boolean isPossible(int[] target) {
        if (target.length == 1) {
            return target[0] == 1;
        }
        // Calculate the initial sum
        long sum = 0;
        for (int el : target) {
            sum += el;
        }
        // Build a max heap to efficiently find the largest element
        buildHeap(target);
        // Work backwards: keep reducing the max element until we reach all 1's
        while (sum > target.length) {
            int max = target[0];
            int maxChild = Math.max(target[1], outOfRange(target, 2) ? Integer.MIN_VALUE : target[2]);
            int diffToMaxChild = max - maxChild;
            long rest = sum - max;
            // Optimization: instead of subtracting rest once, calculate how many times we can subtract
            long timesToSubtractSum = diffToMaxChild / rest;
            if (timesToSubtractSum == 0) {
                timesToSubtractSum = 1;
            }
            long maxUpdated = max - (timesToSubtractSum * rest);
            if (maxUpdated <= 0) {
                return false;
            }
            target[0] = (int) maxUpdated;
            sum = rest + maxUpdated;
            // Restore heap property after updating the root
            sinkTop(target);
        }
        return true;
    }

    /**
     * Builds a max heap from the array by bubbling up each element.
     *
     * @param array the array to heapify
     */
    private void buildHeap(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int idx = i;
            int parentIdx = getParentIdx(idx);
            // Bubble up the element to maintain heap property
            while (!outOfRange(array, parentIdx) && array[parentIdx] < array[idx]) {
                swap(array, idx, parentIdx);
                idx = parentIdx;
                parentIdx = getParentIdx(idx);
            }
        }
    }

    /**
     * Sinks the top element down to restore the max heap property.
     * Used after updating the root element.
     *
     * @param array the heap array
     */
    private void sinkTop(int[] array) {
        int idx = 0;
        int maxIdx = 0;
        while (array[idx] <= array[maxIdx]) {
            swap(array, idx, maxIdx);
            idx = maxIdx;
            int childLeftIdx = getChildLeftIdx(idx);
            if (outOfRange(array, childLeftIdx)) {
                return;
            }
            int childRightIdx = childLeftIdx + 1;
            maxIdx = outOfRange(array, childRightIdx) || array[childLeftIdx] > array[childRightIdx]
                    ? childLeftIdx : childRightIdx;
        }
    }

    /**
     * Calculates the parent index in a binary heap.
     *
     * @param idx the child index
     * @return the parent index, or -1 if idx is the root
     */
    private int getParentIdx(int idx) {
        if (idx == 0) {
            return -1;
        }
        return ((idx + 1) >> 1) - 1;
    }

    /**
     * Calculates the left child index in a binary heap.
     *
     * @param idx the parent index
     * @return the left child index
     */
    private int getChildLeftIdx(int idx) {
        return ((idx + 1) << 1) - 1;
    }

    /**
     * Checks if an index is out of bounds for the array.
     *
     * @param array the array to check against
     * @param idx the index to check
     * @return true if the index is out of range, false otherwise
     */
    private boolean outOfRange(int[] array, int idx) {
        return idx < 0 || idx >= array.length;
    }

    /**
     * Swaps two elements in the array.
     *
     * @param array the array containing the elements
     * @param idx1 the first index
     * @param idx2 the second index
     */
    private void swap(int[] array, int idx1, int idx2) {
        if (idx1 == idx2) {
            return;
        }
        int tmp = array[idx1];
        array[idx1] = array[idx2];
        array[idx2] = tmp;
    }
}