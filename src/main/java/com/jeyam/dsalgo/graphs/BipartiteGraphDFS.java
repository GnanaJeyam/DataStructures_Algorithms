package com.jeyam.dsalgo.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://takeuforward.org/graph/bipartite-graph-dfs-implementation/
 */
public class BipartiteGraphDFS {

    /**
     * If a graph does not have cycle then it is bipartite graph
     * If a graph have Cycle but with even nodes then it is bipartite graph.
     * The approach is to colour all the nodes with alternate colors like 0 or 1
     * If the node is already coloured, and it has the same value then it is not a
     * bipartite graph
     */

    public static void main(String[] args) {
        var adjList = new ArrayList<List<Integer>>();
        adjList.addAll(
            List.of(
                List.of(1),
                List.of(0, 2),
                List.of(0, 1)
            )
        );

        int vertex = adjList.size();
        int visited[] = new int[vertex+1];
        for (int i = 0; i < vertex; i++) {
            visited[i] = -1;
        }

        int result = 1;
        for (int i = 0; i < vertex; i++) {
            if (visited[i] == -1) {
                visited[i] = 0;
                var bipartite = dfs(adjList, visited, i);
                if (!bipartite) {
                    result = 0;
                    break;
                }
            }
        }

        System.out.println("Output" + result);
    }

    private static boolean dfs(ArrayList<List<Integer>> adjList,
                              int[] visited,
                              int index) {

        for (var neighbour: adjList.get(index)) {
            if (visited[neighbour] == -1) {
                visited[neighbour] = 1 - visited[index];
                var dfs = dfs(adjList, visited, neighbour);
                if (!dfs) {
                    return false;
                }
            } else if(visited[neighbour] == visited[index]) {
                return false;
            }
        }

        return true;
    }
}
