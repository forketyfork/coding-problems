package com.forketyfork.codingproblems;

import java.util.HashSet;

/**
 * Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
 * <p>
 * For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
 * <p>
 * Bonus: Can you do this in one pass?
 *
 * @see "Daily Coding Problem #1"
 * @see TwoSum
 */
public class TwoSumExists {

    public boolean check(int target, int[] array) {
        var seen = new HashSet<Integer>();
        for (int value : array) {
            if (seen.contains(target - value)) {
                return true;
            }
            seen.add(value);
        }
        return false;
    }

}
