package com.forketyfork.codingproblems;

/**
 * You are given an integer array nums. You have an integer array arr of the same length with all values set to
 * 0 initially. You can modify the array by either adding 1 to any particular cell, or multiplying all the cells by 2.
 * <p>
 * You want to use these operations to covert arr to nums using the minimum number of calls.
 * <p>
 * Return the minimum number of operations to make nums from arr.
 * <p>
 * The test cases are generated so that the answer fits in a 32-bit signed integer.
 *
 * @see <a href="https://leetcode.com/problems/minimum-numbers-of-function-calls-to-make-target-array/">LeetCode #1558. Minimum Numbers of Function Calls to Make Target Array</a>
 */
public class MinimumFunctionCalls {

    public int minOperations(int[] nums) {
        int maxMultiplications = 0;
        int additions = 0;

        for (int num : nums) {
            int multiplications = -1;
            while (num >= 1) {
                multiplications++;
                additions += (num & 1);
                num >>= 1;
            }
            if (multiplications > maxMultiplications) {
                maxMultiplications = multiplications;
            }
        }

        return maxMultiplications + additions;
    }

}
