package com.jeyam.dsalgo.graphs;

import java.util.LinkedList;
import java.util.List;

/**
 * https://takeuforward.org/data-structure/detect-a-cycle-in-directed-graph-topological-sort-kahns-algorithm-g-23/
 */
public class DetectCycleInDirectedGraphUsingTopoSortKahnAlgorithm {

    public static void main(String[] args) {
        var adjList = List.<List<Integer>>of(
            List.of(),
            List.of(2),
            List.of(3, 4),
            List.of(1),
            List.of()
        );
        var vertices = adjList.size();
        int inDegrees[] = new int[vertices];

        // Update the indegree value for each node
        for (int i = 0; i < vertices; i++) {
            adjList.get(i).forEach(node -> inDegrees[node]++);
        }

        var queue = new LinkedList<Integer>();

        for (int i = 0; i < vertices; i++) {
            if (inDegrees[i] == 0) {
                queue.add(i);
            }
        }

        int count = 0;
        // BFS
        while (!queue.isEmpty()) {
            var node  = queue.pop();
            count++;

            for (var neighbor : adjList.get(node)) {
                inDegrees[neighbor]--;
                if (inDegrees[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        var output = count != vertices;

        System.out.print("Result: " + (output ? "Have cycle" : "Does not Have cycle "));
    }
}
