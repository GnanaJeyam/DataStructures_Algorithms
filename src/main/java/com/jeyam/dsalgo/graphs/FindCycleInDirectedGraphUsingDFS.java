package com.jeyam.dsalgo.graphs;

import java.util.List;

/**
 * https://takeuforward.org/data-structure/detect-cycle-in-a-directed-graph-using-dfs-g-19/
 */
public class FindCycleInDirectedGraphUsingDFS {

    public static void main(String[] args) {
        var adjList = List.<List<Integer>>of(
            List.of(),
            List.of(2),
            List.of(3),
            List.of(4),
            List.of(0)
        );

        var vertex = adjList.size();
        boolean visited [] = new boolean[vertex];
        boolean pathVisited[] = new boolean[vertex];
        var result = false;

        for (int i=1; i<vertex; i++) {
            if (!visited[i]) {
                if (dfs(i, adjList, visited, pathVisited)) {
                    result = true;
                }
            }
        }

        System.out.println("Result " + result);
    }

    private static boolean dfs(int node,
                            List<List<Integer>> adjList,
                            boolean[] visited,
                            boolean[] pathVisited) {

        visited[node] = pathVisited[node] = true;
        for (var neighbour: adjList.get(node)) {
            if (!visited[neighbour]) {
                var dfs = dfs(neighbour, adjList, visited, pathVisited);
                if (dfs) {
                    return true;
                }
            } else if(pathVisited[neighbour]){
                return true;
            }
        }

        pathVisited[node] = false;

        return false;
    }
}
