package com.jeyam.dsalgo.graphs;

import java.util.List;
import java.util.Stack;

/**
 * https://takeuforward.org/data-structure/topological-sort-algorithm-dfs-g-21/
 */

public class TopologicalSortUsingDFS {

    public static void main(String[] args) {
        var adjList = List.<List<Integer>>of(
                List.of(),
                List.of(0),
                List.of(0),
                List.of(0)
        );

        var vertices = adjList.size();
        boolean visited[]  = new boolean[vertices];
        var stack  =  new Stack<Integer>();

        for (int i = 0; i <vertices; i++) {
            if (!visited[i]) {
                dfs(i, visited, adjList, stack);
            }
        }

        while (!stack.isEmpty()) {
            var pop = stack.pop();
            System.out.print(" " + pop);
        }

    }

    private static void dfs(int node,
                            boolean[] visited,
                            List<List<Integer>> adjList,
                            Stack<Integer> stack) {
        visited[node] = true;

        for (var neighbour: adjList.get(node)) {
            if (!visited[neighbour]) {
                dfs(neighbour, visited, adjList, stack);
            }
        }

        stack.add(node);
    }
}
