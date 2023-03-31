package com.jeyam.dsalgo.graphs;

import java.util.List;

/**
 * * https://takeuforward.org/data-structure/depth-first-search-dfs/
 */
public class DFS {

    public static void main(String[] args) {
        // 0 based indexing | Adjacency list
        List<List<Integer>> adjList = List.of(
            List.of(1, 4),
            List.of(0, 2, 3),
            List.of(1),
            List.of(1),
            List.of(0)
        );

        boolean visited[] = new boolean[5];
        dfs(0, adjList, visited);
    }

    static void dfs(int node, List<List<Integer>> adjList, boolean visited[]) {
        visited[node] = true;
        System.out.print(node + " ");

        for (int neighbour: adjList.get(node)) {
            if (!visited[neighbour]) {
                dfs(neighbour, adjList, visited);
            }
        }

    }
}
