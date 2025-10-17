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

    /**
     * Represents the color assigned to a vertex in the bipartite graph coloring.
     */
    enum Color {
        UNCOLORED,
        RED,
        BLACK;

        /**
         * Returns the complementary color (RED becomes BLACK, BLACK becomes RED).
         *
         * @return the opposite color, or UNCOLORED if this color is UNCOLORED
         */
        Color complement() {
            return switch (this) {
                case RED -> BLACK;
                case BLACK -> RED;
                default -> UNCOLORED;
            };
        }
    }

    /**
     * Determines if a graph is bipartite using BFS with 2-coloring.
     * A graph is bipartite if and only if it can be 2-colored (no two adjacent vertices have the same color).
     *
     * @param graph the graph represented as an adjacency list (graph[i] contains all neighbors of vertex i)
     * @return true if the graph is bipartite, false otherwise
     *
     * <p>Time Complexity: O(V + E) where V is the number of vertices and E is the number of edges
     * <p>Space Complexity: O(V) for the color array and BFS queue
     *
     * <p>Algorithm: Use BFS to color the graph. If we ever need to color a vertex that's already
     * colored with the wrong color, the graph is not bipartite.
     */
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;

        var colors = new Color[n];
        for (int i = 0; i < n; i++) {
            colors[i] = Color.UNCOLORED;
        }

        var queue = new ArrayDeque<Integer>();

        // Process each connected component separately (graph may be disconnected)
        for (int i = 0; i < n; i++) {
            if (colors[i] == Color.UNCOLORED) {

                // Start BFS from this vertex, coloring it RED
                colors[i] = Color.RED;
                queue.offer(i);

                while (!queue.isEmpty()) {
                    int v = queue.poll();
                    var vColor = colors[v];
                    var complementColor = vColor.complement();

                    // Color all neighbors with the complement color
                    for (int u : graph[v]) {
                        var uColor = colors[u];

                        // If neighbor has same color, graph is not bipartite
                        if (uColor == vColor) {
                            return false;
                        }
                        // If neighbor is uncolored, color it and add to queue
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
