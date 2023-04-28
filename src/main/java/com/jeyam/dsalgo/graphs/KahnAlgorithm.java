package com.jeyam.dsalgo.graphs;

import java.util.LinkedList;
import java.util.List;

public class KahnAlgorithm {

    public static void main(String[] args) {
        var adjList = List.<List<Integer>>of(
                List.of(),
                List.of(0),
                List.of(0),
                List.of(0)
        );

        var vertices = adjList.size();
        int indegree[] = new int[vertices];

        for (int st = 0; st < vertices ; st++) {
            for (var node: adjList.get(st)) {
                indegree[node]++;
            }
        }

        var queue = new LinkedList<Integer>();

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        // BFS

        int start = 0;
        int result[] = new int[vertices];

        while (!queue.isEmpty()) {
            var pop = queue.pop();
            result[start++] = pop;

            for (Integer neighbor: adjList.get(pop)){
                indegree[neighbor]--;
                if (indegree[neighbor] == 0){
                    queue.add(neighbor);
                }
            }
        }

        for (int i = 0; i < vertices; i++) {
            System.out.print(" "+ result[i]);
        }

    }
}
