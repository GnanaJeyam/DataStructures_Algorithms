package com.jeyam.dsalgo.graphs;

/**
 * https://takeuforward.org/graph/breadth-first-search-bfs-level-order-traversal/
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BFS {

    private static List<Integer> bfs(List<List<Integer>> adjList, int vertices) {
        boolean visited[] = new boolean[vertices+1];
        var result = new ArrayList<Integer>();
        var queue = new LinkedList<Integer>();

        queue.add(1);
        visited[1] = true;

        while (!queue.isEmpty()) {
            var node = queue.poll();
            result.add(node);

            for (Integer value: adjList.get(node)) {
                if (!visited[value]) {
                    visited[value] = true;
                    queue.add(value);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // 1-Based indexing | Adding an empty entry for 0th index
        List<List<Integer>> adjList = List.of(
            List.of(),
            List.of(2, 5),
            List.of(1, 3, 5),
            List.of(2, 4, 5),
            List.of(3, 5),
            List.of(1, 2, 3, 4)
        );

        List<Integer> bfs = bfs(adjList, 5);
        bfs.forEach(System.out::println);
    }
}
