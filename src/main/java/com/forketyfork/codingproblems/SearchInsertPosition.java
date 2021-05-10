package com.forketyfork.codingproblems;

/**
 * Given a sorted array of distinct integers and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 * <p>
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * @see <a href="https://leetcode.com/problems/search-insert-position/">LeetCode #35. Search Insert Position</a>
 */
class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {

        // To satisfy the complexity conditions, we use binary search.

        // The interval of indexes [first, last).
        // The element (if it's present) is somewhere between `first` (inclusive) and `last` (exclusive) index
        int first = 0;
        int last = nums.length;

        // Repeat until the interval is just one element.
        while (last - first > 1) {
            // At this point, the target element (if it's present in the array) should be in the interval [first, last).

            // Find the element in the middle between the `first` and the `last` one.
            int middle = (last + first) >> 1;
            int middleElement = nums[middle];

            // Replace the `first` or the `last` index with `middle`, depending on whether `middle` element is less than
            // or greater than the `target`. If the `middle` element is equal to the `target`, then we've found what
            // we're looking for - return the `middle` index.
            if (target < middleElement) {
                last = middle;
            }
            else if (target > middleElement) {
                first = middle + 1;
            }
            else {
                // we've found the element, returning its index
                return middle;
            }
        }

        // If we end up here, it means we didn't find the element, but we converged to the nearest one
        // (the one at index `first`), so we need to return its index or the index of the next one,
        // depending on whether it's less than or greater than the `target`.
        // We also cover the case when the first index is out of the array.
        if (first >= nums.length || nums[first] >= target) {
            return first;
        }
        return first + 1;
    }
}