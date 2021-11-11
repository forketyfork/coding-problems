package com.forketyfork.codingproblems;

/**
 *
 * Given an m x n matrix mat, return an array of all the elements of the array in a diagonal order.
 * @see <a href="https://leetcode.com/problems/diagonal-traverse/">LeetCode #498. Diagonal Traverse</a>
 */
public class DiagonalTraverse {

    public int[] findDiagonalOrder(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;
        int[] result = new int[n * m];
        boolean up = true;
        int i = 0;
        int j = 0;
        int right = n - 1;
        int bottom = m - 1;

        for (int k = 0; k < result.length; k++) {

            result[k] = mat[i][j];

            if (up && j == right) {
                up = false;
                i++;
            }
            else if (up && i == 0) {
                up = false;
                j++;
            }
            else if (!up && i == bottom) {
                up = true;
                j++;
            }
            else if (!up && j == 0) {
                up = true;
                i++;
            }
            else if (up) {
                i--;
                j++;
            }
            else {
                i++;
                j--;
            }

        }

        return result;
    }
}

