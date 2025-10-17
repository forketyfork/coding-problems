package com.forketyfork.codingproblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 *
 * @see <a href="https://leetcode.com/problems/pascals-triangle/">LeetCode #118. Pascal's Triangle</a>
 */
public class PascalTriangle {

    /**
     * Generates the first numRows of Pascal's triangle using recursion.
     * Each row is computed from the previous row.
     *
     * @param numRows the number of rows to generate
     * @return a list of lists representing Pascal's triangle
     *
     * <p>Time Complexity: O(n^2) where n is numRows (total number of elements generated)
     * <p>Space Complexity: O(n^2) for storing the triangle, plus O(n) recursion stack
     */
    public List<List<Integer>> generate(int numRows) {
        if (numRows == 1) {
            return new ArrayList<>(Collections.singletonList(Collections.singletonList(1)));
        }
        else {
            List<List<Integer>> result = generate(numRows - 1);
            List<Integer> lastRow = result.get(result.size() - 1);
            List<Integer> nextRow = new ArrayList<>(numRows);
            for (int i = 0; i < numRows; i++) {
                int left = i == 0 ? 0 : lastRow.get(i - 1);
                int right = i == numRows - 1 ? 0 : lastRow.get(i);
                nextRow.add(left + right);
            }
            result.add(nextRow);
            return result;
        }
    }

}
