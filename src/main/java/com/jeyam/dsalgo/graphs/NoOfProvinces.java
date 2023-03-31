package com.jeyam.dsalgo.graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * * https://takeuforward.org/data-structure/number-of-provinces/
 */
public class NoOfProvinces {

    public static void main(String[] args) {
        var adjMatrix = new ArrayList<List<Integer>>();
        adjMatrix.addAll(List.of(
                List.of(),
                List.of(2, 3),
                List.of(1, 4),
                List.of(1, 4),
                List.of(2, 3, 5),
                List.of(4),
                List.of(7, 8),
                List.of(6, 8),
                List.of(6, 7),
                List.of(10),
                List.of(9)
        ));

        calculateNumberOfProvinces(adjMatrix, 10);
    }

    private static void calculateNumberOfProvinces(List<List<Integer>> adjMatrix, int vertices) {
        boolean visited[] = new boolean[vertices+1];
        int count = 0;
        for (int i=1; i<=vertices; i++) {
            if (!visited[i]) {
                dfs(i, adjMatrix, visited);
                count++;
            }
        }

        System.out.print("Final Output: " + count);
    }

    private static void dfs(int node, List<List<Integer>> adjList, boolean visited[]) {
        visited[node] = true;
        for (var neighbour : adjList.get(node)) {
            if (!visited[neighbour]) {
                dfs(neighbour, adjList, visited);
            }
        }
    }
}
