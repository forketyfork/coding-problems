package com.forketyfork.codingproblems;

/**
 * Given a non-empty array of decimal digits representing a non-negative integer, increment one to the integer.
 * <p>
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contains a single digit.
 * <p>
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 *
 * @see <a href=https://leetcode.com/problems/plus-one/>LeetCode #66. Plus One</a>
 */
class PlusOne {

    public int[] plusOne(int[] digits) {

        // walking the array from right to left, searching for the first digit which is not 9
        // this digit can be increased without carry
        for (int i = digits.length - 1; i >= 0; i--) {

            int digitValue = digits[i] + 1;

            if (digitValue < 10) {
                // we've found a digit that can be increased without carry,
                // so we increase it and return the array
                digits[i] = digitValue;
                return digits;
            }
            else {
                // we have a carry, so we need to continue searching
                digits[i] = digitValue - 10;
            }
        }

        // if we end up here, this means that all digits were 9, and we need to extend the array by 1 to the left
        int[] newArray = new int[digits.length + 1];
        newArray[0] = 1;
        System.arraycopy(digits, 0, newArray, 1, digits.length);
        return newArray;

    }
}
