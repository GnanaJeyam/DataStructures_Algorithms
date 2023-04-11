package com.jeyam.dsalgo.graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * * https://takeuforward.org/data-structure/detect-cycle-in-an-undirected-graph-using-dfs/
 */
public class FindCycleInUndirectedGraphUsingDFS {
    public static void main(String[] args) {
        var adjList = List.of(
                new ArrayList<Integer>(),
                List.of(2),
                List.of(3),
                List.of(2),
                new ArrayList<Integer>()
        );

        var vertices = adjList.size();
        boolean visited[] = new boolean[vertices + 1];
        boolean hasCycle = false;
        for (int i = 1; i < vertices; i++) {
            if (!visited[i]) {
                if (detectCycleUsingDFS(adjList, i, -1, visited)) {
                    hasCycle = true;
                    break;
                }
            }
        }

        System.out.println(hasCycle);
    }

    private static boolean detectCycleUsingDFS(List<List<Integer>> adjList,
                                               int node,
                                               int parent,
                                               boolean[] visited) {
        visited[node] = true;

        for (var neighbour: adjList.get(node)) {
            if (!visited[neighbour]) {
                if (detectCycleUsingDFS(adjList, neighbour, node, visited)) {
                    return true;
                }
            } else {
                if (neighbour != parent) {
                    return true;
                }
            }
        }

        return false;
    }
}