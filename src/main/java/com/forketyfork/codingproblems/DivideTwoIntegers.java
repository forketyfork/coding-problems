package com.forketyfork.codingproblems;

/**
 * Given two integers dividend and divisor, divide two integers without using multiplication,
 * division, and mod operator. The integer division should truncate toward zero.
 * Return the quotient after dividing dividend by divisor.
 *
 * @see <a href="https://leetcode.com/problems/divide-two-integers/">LeetCode #29. Divide Two Integers</a>
 */
class DivideTwoIntegers {

    /**
     * Divides two integers using bit shifting and subtraction.
     * The algorithm repeatedly doubles the divisor (via left shift) to find the largest
     * multiple that fits in the dividend, then subtracts and repeats.
     *
     * @param dividend the number to be divided
     * @param divisor the number to divide by
     * @return the quotient (truncated toward zero)
     *
     * <p>Time Complexity: O(log^2(n)) where n is the dividend
     * <p>Space Complexity: O(1)
     *
     * <p>Special case: If dividend is Integer.MIN_VALUE and divisor is -1,
     * the result would overflow, so Integer.MAX_VALUE is returned instead.
     */
    public int divide(int dividend, int divisor) {
        // Handle overflow case
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if (divisor == 1) {
            return dividend;
        }
        // Use long to avoid overflow when taking absolute value of Integer.MIN_VALUE
        long ldividend = Math.abs((long) dividend);
        long ldivisor = Math.abs((long) divisor);
        // Determine sign of result (positive if both have same sign)
        boolean sign = dividend >= 0 && divisor >= 0 || dividend < 0 && divisor < 0;
        long result = 0;
        long multiplier = 1;
        long shiftedDivisor = ldivisor;
        // Phase 1: Shift divisor left until it exceeds dividend
        while (shiftedDivisor <= ldividend) {
            multiplier <<= 1;
            shiftedDivisor <<= 1;
        }
        // Phase 2: Shift back right, subtracting when possible
        while (multiplier > 0) {
            if (ldividend >= shiftedDivisor) {
                ldividend -= shiftedDivisor;
                result += multiplier;
            }
            multiplier >>= 1;
            shiftedDivisor >>= 1;
        }
        return (int) (sign ? result : -result);
    }
}