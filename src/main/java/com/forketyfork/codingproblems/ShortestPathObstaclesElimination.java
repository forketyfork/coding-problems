package com.forketyfork.codingproblems;

import java.util.ArrayDeque;
import java.util.Queue;

public class ShortestPathObstaclesElimination {

    private static final int[][] directions = new int[][] {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public int shortestPath(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int n_1 = n - 1;
        int m_1 = m - 1;

        boolean[][][] visited = new boolean[n][m][k + 1];

        Queue<int[]> queue = new ArrayDeque<>();

        queue.offer(new int[] {0, 0, 0});

        int shortestPath = 0;

        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int q = 0; q < queueSize; q++) {
                int[] cell = queue.poll();
                int i = cell[0];
                int j = cell[1];
                int currentK = cell[2];

                if (i == n_1 && j == m_1) {
                    return shortestPath;
                }

                for (int[] direction : directions) {
                    int nextI = i + direction[0];
                    int nextJ = j + direction[1];
                    if (nextI >= 0 && nextI < n && nextJ >= 0 && nextJ < m
                            && !visited[nextI][nextJ][currentK]) {
                        visited[nextI][nextJ][currentK] = true;
                        if (grid[nextI][nextJ] == 0) {
                            queue.offer(new int[] {nextI, nextJ, currentK});
                        }
                        else if (currentK < k) {
                            queue.offer(new int[] {nextI, nextJ, currentK + 1});
                        }
                    }
                }
            }
            shortestPath++;
        }

        return -1;

    }

}

