package com.jeyam.dsalgo.graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * * https://takeuforward.org/data-structure/find-eventual-safe-states-dfs-g-20/
 */
public class FindEventualSafeStates {
    public static void main(String[] args) {
        var adjList = List.<List<Integer>>of(
                List.of(1),
                List.of(2),
                List.of(0, 3),
                List.of()
        );

        var vertex = adjList.size();
        boolean visited [] = new boolean[vertex];
        boolean pathVisited[] = new boolean[vertex];
        boolean safeNode[] = new boolean[vertex];

        for (int i=0; i<vertex; i++) {
            if (!visited[i]) {
                dfs(i, adjList, visited, pathVisited, safeNode);
            }
        }
        var safeNodes = new ArrayList<Integer>();
        for (int i = 0; i < vertex; i++) {
            if (safeNode[i]) {
                safeNodes.add(i);
            }
        }

        System.out.println("Safe Nodes " + safeNodes);
    }

    private static boolean dfs(int node,
                               List<List<Integer>> adjList,
                               boolean[] visited,
                               boolean[] pathVisited,
                               boolean[] safeNodes) {

        visited[node] = pathVisited[node] = true;
        safeNodes[node] = false;

        for (var neighbour: adjList.get(node)) {
            if (!visited[neighbour]) {
                var dfs = dfs(neighbour, adjList, visited, pathVisited, safeNodes);
                if (dfs) {
                    return true;
                }
            } else if(pathVisited[neighbour]){
                return true;
            }
        }

        safeNodes[node] = true;
        pathVisited[node] = false;

        return false;
    }
}
