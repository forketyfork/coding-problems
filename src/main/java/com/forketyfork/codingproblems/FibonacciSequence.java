package com.forketyfork.codingproblems;

import java.util.ArrayList;
import java.util.List;

/**
 * Generate the Fibonacci sequence of length n.
 * <p>
 * The Fibonacci sequence starts with 0 and 1, and each subsequent number is the sum of the two
 * preceding ones: 0, 1, 1, 2, 3, 5, 8, 13, ...
 * <p>
 * Given a non-negative integer n, return a list containing the first n numbers in the Fibonacci
 * sequence.
 */
public class FibonacciSequence {

    public List<Integer> generate(int n) {
        List<Integer> result = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            if (i < 2) {
                result.add(i);
            } else {
                result.add(result.get(i - 1) + result.get(i - 2));
            }
        }
        return result;
    }

}
