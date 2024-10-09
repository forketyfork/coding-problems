package com.forketyfork.codingproblems;

import java.util.ArrayDeque;

/**
 * Given an undirected graph G, check whether it is bipartite. Recall that a graph is bipartite if its vertices
 * can be divided into two independent sets, U and V, such that no edge connects vertices of the same set.
 *
 * @see <a href="https://leetcode.com/problems/is-graph-bipartite/">LeetCode #718. Is Graph Bipartite?</a>
 * @see "Daily Coding Problem #207"
 */
public class IsGraphBipartite {

    enum Color {
        UNCOLORED,
        RED,
        BLACK;

        Color complement() {
            return switch (this) {
                case RED -> BLACK;
                case BLACK -> RED;
                default -> UNCOLORED;
            };
        }
    }

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;

        var colors = new Color[n];
        for (int i = 0; i < n; i++) {
            colors[i] = Color.UNCOLORED;
        }

        var queue = new ArrayDeque<Integer>();

        for (int i = 0; i < n; i++) {
            if (colors[i] == Color.UNCOLORED) {

                colors[i] = Color.RED;
                queue.offer(i);

                while (!queue.isEmpty()) {
                    int v = queue.poll();
                    var vColor = colors[v];
                    var complementColor = vColor.complement();

                    for (int u : graph[v]) {
                        var uColor = colors[u];

                        if (uColor == vColor) {
                            return false;
                        }
                        if (uColor == Color.UNCOLORED) {
                            queue.offer(u);
                            colors[u] = complementColor;
                        }
                    }
                }
            }
        }
        return true;
    }
}
