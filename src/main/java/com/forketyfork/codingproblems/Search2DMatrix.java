package com.forketyfork.codingproblems;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * <p>
 * * Integers in each row are sorted from left to right.
 * * The first integer of each row is greater than the last integer of the previous row.
 *
 * @see <a href="https://leetcode.com/problems/search-a-2d-matrix/">LeetCode #74. Search a 2D Matrix</a>
 */
public class Search2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length, cols = matrix[0].length;
        int begin = 0, end = rows * cols;
        while (begin < end) {
            int middle = (begin + end) >> 1;
            int row = middle / cols;
            int col = middle % cols;
            int value = matrix[row][col];
            if (value == target) {
                return true;
            }
            else if (value < target) {
                begin = middle + 1;
            }
            else {
                end = middle;
            }
        }
        return false;
    }

}
