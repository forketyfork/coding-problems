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

    /**
     * Calculates the minimum number of operations (additions and multiplications) needed
     * to create the target array from an array of all zeros. Works backwards by analyzing
     * the binary representation of target numbers.
     *
     * @param nums the target array of non-negative integers
     * @return the minimum number of operations required
     *
     * <p>Time Complexity: O(n * log(max_num)) where n is array length and max_num is the largest value
     * <p>Space Complexity: O(1)
     *
     * <p>Algorithm (working backwards from target):
     * - Each 1 bit in a number requires one addition operation
     * - The number of right shifts (multiplications when going forward) is the bit length - 1
     * - Total ops = sum of all 1-bits + maximum bit-length across all numbers - 1
     */
    public int minOperations(int[] nums) {
        int maxMultiplications = 0;
        int additions = 0;

        for (int num : nums) {
            int multiplications = -1;  // Start at -1 to account for the initial value
            while (num >= 1) {
                multiplications++;  // Count the number of bits (positions)
                additions += (num & 1);  // Count 1-bits (addition operations)
                num >>= 1;  // Shift right (division by 2, reverse of multiplication)
            }
            if (multiplications > maxMultiplications) {
                maxMultiplications = multiplications;
            }
        }

        // Multiplication operations are global (affect all elements),
        // so we only need as many as required for the element with most bits
        return maxMultiplications + additions;
    }

}
