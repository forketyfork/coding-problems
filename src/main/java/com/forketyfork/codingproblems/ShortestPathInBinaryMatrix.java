package com.forketyfork.codingproblems;

import java.util.ArrayDeque;

/**
 * Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix.
 * If there is no clear path, return -1.
 * <p>
 * A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell
 * (i.e., (n - 1, n - 1)) such that:
 * <p>
 * All the visited cells of the path are 0.
 * All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge
 * or a corner).
 * The length of a clear path is the number of visited cells of this path.
 *
 * @see <a href="https://leetcode.com/problems/shortest-path-in-binary-matrix/">LeetCode #1091. Shortest Path in Binary Matrix</a>
 */
public class ShortestPathInBinaryMatrix {

    public int shortestPathBinaryMatrix(int[][] grid) {

        int n = grid.length;
        int n_1 = n - 1;

        if (grid[0][0] == 1 || grid[n_1][n_1] == 1) {
            return -1;
        }

        ArrayDeque<int[]> queue = new ArrayDeque<>();

        int[][] directions = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {-1, -1}, {1, 1}, {-1, 1}, {1, -1}};

        queue.offer(new int[] {0, 0, 0});

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int i = cell[0];
            int j = cell[1];
            int pathLen = cell[2] + 1;
            if (i == n_1 && j == n_1) {
                return pathLen;
            }

            for (int[] direction : directions) {
                int nextI = i + direction[0];
                int nextJ = j + direction[1];
                if (nextI >= 0 && nextI < n && nextJ >= 0 && nextJ < n && grid[nextI][nextJ] == 0) {
                    grid[nextI][nextJ] = -1;
                    queue.offer(new int[] {nextI, nextJ, pathLen});
                }
            }
        }

        return -1;

    }
}