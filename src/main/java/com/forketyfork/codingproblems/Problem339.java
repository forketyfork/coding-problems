package com.forketyfork.codingproblems;

import java.util.HashSet;
import java.util.Set;

/**
 * This problem was asked by Microsoft.
 * <p>
 * Given an array of numbers and a number k, determine if there are three entries in the array
 * which add up to the specified number k. For example, given [20, 303, 3, 4, 25] and k = 49,
 * return true as 20 + 4 + 25 = 49.
 *
 * @see "Daily Coding Problem #339"
 */
public class Problem339 {

    public boolean sum3(int[] array, int k) {
        if (array.length < 3) {
            return false;
        }
        for (int i = 0; i < array.length; i++) {
            int diff = k - array[i];
            if (sum2(array, diff, i)) {
                return true;
            }
        }
        return false;
    }

    private boolean sum2(int[] array, int k, int excludeIdx) {
        Set<Integer> seen = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            if (i == excludeIdx) {
                continue;
            }
            if (seen.contains(k - array[i])) {
                return true;
            }
            seen.add(array[i]);
        }
        return false;
    }

}
