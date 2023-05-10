package com.jeyam.dsalgo.graphs;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * https://takeuforward.org/data-structure/shortest-path-in-directed-acyclic-graph-topological-sort-g-27/
 */
public class ShortestPathInDAG {

    public static void main(String[] args) {
        var adjPairList = Arrays.<List<Pair>>asList(
                List.of(new Pair(1, 2), new Pair(4, 1)),
                List.of(new Pair(2, 3)),
                List.of(new Pair(3, 6)),
                List.of(),
                List.of(new Pair(5, 4),new Pair(2, 2)),
                List.of(new Pair(3, 1))
        );

        var vertices = adjPairList.size();
        boolean visited[] = new boolean[vertices];
        var stack = new Stack<Integer>();

        // Find Topo Sort.
        for (int i = 0; i < vertices ; i++) {
            if (!visited[i]) {
                dfs(i, adjPairList, visited, stack);
            }
        }

        // Identify the distance
        int distance[] = new int[vertices];
        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[0] = 0;
        while (!stack.isEmpty()) {
            var top = stack.pop();
            for (var neighbour: adjPairList.get(top)) {
                var node = neighbour.getR();
                var weight = neighbour.getC();

                if (distance[top] + weight < distance[node]) {
                    distance[node] = distance[top] + weight;
                }
            }
        }

        for (int i = 0; i < vertices; i++) {
            System.out.print(distance[i] +"  ");
        }


    }

    private static void dfs(int node,
                            List<List<Pair>> adjPairList,
                            boolean visited[],
                            Stack<Integer> stack) {

        visited[node] = true;

        for (var neighbour: adjPairList.get(node)) {
            var r = neighbour.getR();
            if (!visited[r]) {
                dfs(r, adjPairList, visited, stack);
            }
        }

        stack.add(node);
    }

}
