package com.forketyfork.codingproblems;

import java.util.ArrayList;

/**
 * Egyptian fractions are a way to represent rational numbers as a sum of unit fractions
 * (fractions with numerator 1). For example, 2/3 = 1/2 + 1/6.
 * This class implements the greedy algorithm to decompose a fraction into Egyptian fractions.
 */
public class EgyptianFractions {

    /**
     * Decomposes a fraction into Egyptian fractions using the greedy algorithm.
     * The algorithm repeatedly finds the largest unit fraction (1/k) that doesn't exceed
     * the remaining fraction, subtracts it, and continues until the numerator becomes 0.
     *
     * @param num the numerator of the fraction
     * @param denom the denominator of the fraction
     * @return an array of denominators representing the Egyptian fraction decomposition
     *
     * <p>Time Complexity: O(num) in the worst case, but typically much faster
     * <p>Space Complexity: O(num) for storing the result
     *
     * <p>Example: egyptian(2, 3) returns [2, 6] representing 1/2 + 1/6 = 2/3
     */
    public Integer[] egyptian(int num, int denom) {
        var denominators = new ArrayList<Integer>();
        do {
            // Find the smallest k such that 1/k <= num/denom
            // This is equivalent to: k >= denom/num, so k = ceil(denom/num)
            int multiplier = (int) Math.ceil(1.0 * denom / num);
            // Subtract 1/multiplier from num/denom
            // num/denom - 1/multiplier = (num*multiplier - denom) / (denom*multiplier)
            num = num * multiplier - denom;
            denom *= multiplier;
            denominators.add(multiplier);
        } while (num > 0);
        return denominators.toArray(new Integer[0]);
    }

}
