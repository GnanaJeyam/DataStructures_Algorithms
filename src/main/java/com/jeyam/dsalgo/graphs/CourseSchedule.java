package com.jeyam.dsalgo.graphs;

import java.util.LinkedList;
import java.util.List;

public class CourseSchedule {

    public static void main(String[] args) {

        var adjList = List.<List<Integer>>of(
            List.of(0, 1),
            List.of(1, 2),
            List.of(2, 3),
            List.of()
        );

        var vertices = adjList.size();
        int inDegrees[] = new int[vertices];
        var queue = new LinkedList<Integer>();

        adjList.forEach(ls -> ls.forEach(node -> inDegrees[node]++));

        for (int i = 0; i < vertices; i++) {
            if (inDegrees[i] == 0) {
                queue.add(i);
            }
        }

        int count = 0;
        int result [] = new int[vertices];
        // BFS
        while (!queue.isEmpty()) {
            var node  = queue.pop();
            result[count] = node;
            count++;

            for (var neighbor : adjList.get(node)) {
                inDegrees[neighbor]--;
                if (inDegrees[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        if (count == vertices) {
            System.out.println("Properties" + result);
        } else {
            System.out.println("Invalid result");
        }

    }
}
