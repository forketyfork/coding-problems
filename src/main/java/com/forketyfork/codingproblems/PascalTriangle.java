package com.forketyfork.codingproblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 */
public class PascalTriangle {

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
