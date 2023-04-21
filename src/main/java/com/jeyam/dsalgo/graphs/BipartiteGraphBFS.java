package com.jeyam.dsalgo.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://takeuforward.org/graph/bipartite-graph-bfs-implementation/
 */
public class BipartiteGraphBFS {

    /**
     * If a graph does not have cycle then it is bipartite graph
     * If a graph have cycle but with even nodes then it is bipartite graph.
     * The approach is to colour all the nodes with alternate colors like 0 or 1
     * If the node is already coloured, and it has the same value then it is not a
     * bipartite graph
     */

    public static void main(String[] args) {
        int vertex = 10;
        var adjList = new ArrayList<List<Integer>>();
        adjList.addAll(
            List.of(
                List.of(),
                List.of(2),
                List.of(1, 3),
                List.of(2, 4, 5),
                List.of(3, 6),
                List.of(3, 7),
                List.of(4, 8),
                List.of(5, 8),
                List.of(6, 7, 9),
                List.of(8, 10),
                List.of(9)
            ));

        int visited[] = new int[vertex+1];
        for (int i = 0; i <= vertex; i++) {
            visited[i] = -1;
        }

        int result = 1;
        for (int i = 1; i <= vertex; i++) {
            if (visited[i] == -1) {
                var queue = new LinkedList<Integer>();
                queue.add(i);
                visited[i] = 0;
                var bipartite = bipartite(adjList, visited, queue);
                if (!bipartite) {
                    result = 0;
                    break;
                }
            }
        }

        System.out.println("Output" + result);
    }

    private static boolean bipartite(ArrayList<List<Integer>> adjList,
                                  int[] visited,
                                  LinkedList<Integer> queue) {

        while (!queue.isEmpty()) {
            var node = queue.pop();

            for (var neighbour: adjList.get(node)) {
                // if the adjacent node is yet not colored
                // you will give the opposite color of the node

                if (visited[neighbour] == -1) {
                    queue.add(neighbour);
                    visited[neighbour] = 1 - visited[node];
                }
                // is the adjacent guy having the same color
                // someone did color it on some other path
                else if (visited[neighbour] == visited[node]) {
                    return false;
                }
            }
        }

        return true;
    }
}
