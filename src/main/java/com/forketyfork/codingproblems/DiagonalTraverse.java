package com.forketyfork.codingproblems;

/**
 * Given an m x n matrix mat, return an array of all the elements of the array in a diagonal order.
 * The diagonal traversal alternates direction: up-right, then down-left, then up-right, etc.
 *
 * @see <a href="https://leetcode.com/problems/diagonal-traverse/">LeetCode #498. Diagonal Traverse</a>
 */
public class DiagonalTraverse {

    /**
     * Traverses the matrix diagonally, alternating between up-right and down-left directions.
     * When reaching a boundary, the direction changes and the traversal continues from the edge.
     *
     * @param mat the input matrix
     * @return an array containing all matrix elements in diagonal order
     *
     * <p>Time Complexity: O(m * n) where m and n are the dimensions of the matrix
     * <p>Space Complexity: O(1) auxiliary space (excluding the output array)
     *
     * <p>Traversal pattern:
     * - Start at (0,0) going up-right
     * - When hitting top or right edge, change to down-left
     * - When hitting bottom or left edge, change to up-right
     * - Continue until all elements are visited
     */
    public int[] findDiagonalOrder(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;
        int[] result = new int[n * m];
        boolean up = true;  // Direction flag: true = up-right, false = down-left
        int i = 0;  // Row index
        int j = 0;  // Column index
        int right = n - 1;
        int bottom = m - 1;

        for (int k = 0; k < result.length; k++) {

            result[k] = mat[i][j];

            // Determine next position based on current position and direction
            if (up && j == right) {
                // Hit right edge while going up: move down and change direction
                up = false;
                i++;
            }
            else if (up && i == 0) {
                // Hit top edge while going up: move right and change direction
                up = false;
                j++;
            }
            else if (!up && i == bottom) {
                // Hit bottom edge while going down: move right and change direction
                up = true;
                j++;
            }
            else if (!up && j == 0) {
                // Hit left edge while going down: move down and change direction
                up = true;
                i++;
            }
            else if (up) {
                // Continue going up-right
                i--;
                j++;
            }
            else {
                // Continue going down-left
                i++;
                j--;
            }

        }

        return result;
    }
}

