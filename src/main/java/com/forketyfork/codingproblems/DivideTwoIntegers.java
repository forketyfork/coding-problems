package com.forketyfork.codingproblems;

class DivideTwoIntegers {

    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if (divisor == 1) {
            return dividend;
        }
        long ldividend = Math.abs((long) dividend);
        long ldivisor = Math.abs((long) divisor);
        boolean sign = dividend >= 0 && divisor >= 0 || dividend < 0 && divisor < 0;
        int result = 0;
        long multiplier = 1;
        long shiftedDivisor = ldivisor;
        while (shiftedDivisor <= ldividend) {
            multiplier <<= 1;
            shiftedDivisor <<= 1;
        }
        while (multiplier > 0) {
            if (ldividend >= shiftedDivisor) {
                ldividend -= shiftedDivisor;
                result += multiplier;
            }
            multiplier >>= 1;
            shiftedDivisor >>= 1;
        }
        return sign ? result : -result;
    }
}