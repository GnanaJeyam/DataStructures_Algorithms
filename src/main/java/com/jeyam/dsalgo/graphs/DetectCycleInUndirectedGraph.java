package com.jeyam.dsalgo.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * * https://takeuforward.org/data-structure/detect-cycle-in-an-undirected-graph-using-bfs/
 */
public class DetectCycleInUndirectedGraph {

    public static void main(String[] args) {
        var adjList = List.of(
                new ArrayList<Integer>(),
                List.of(2),
                List.of(3),
                List.of(2),
                new ArrayList<Integer>()
        );

        boolean visited [] = new boolean[adjList.size() + 1];
        int result = 0;
        for (int i=1; i<4; i++) {
            boolean hasCycle = false;
            if(!visited[i]) {
                hasCycle = detectCycle(adjList, i, visited);
            }
            if (hasCycle) {
                result = 1;
                break;
            }
        }
        System.out.println(result);
    }

    private static boolean detectCycle(List<List<Integer>> adjList, int startingNode, boolean[] visited) {
        var queue = new LinkedList<Pair>();
        queue.add(new Pair(startingNode, -1));

        while (!queue.isEmpty()) {
            var pair = queue.pop();
            var node = pair.getR();
            visited[node] = true;
            var parent = pair.getC();

            for (var adj : adjList.get(node)) {
                if (!visited[adj]) {
                    visited[adj] = true;
                    queue.add(new Pair(adj, node));
                } else {
                    if (adj != parent) {
                      return true;
                    }
                }
            }
        }

        return false;
    }
}
