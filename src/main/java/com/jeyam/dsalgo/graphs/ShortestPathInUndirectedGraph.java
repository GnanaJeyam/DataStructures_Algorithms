package com.jeyam.dsalgo.graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://takeuforward.org/data-structure/shortest-path-in-undirected-graph-with-unit-distance-g-28/
 */
public class ShortestPathInUndirectedGraph {
    public static void main(String[] args) {
        var adjPairList = Arrays.<List<Integer>>asList(
                List.of(1, 3),
                List.of(2),
                List.of(6),
                List.of(4),
                List.of(5),
                List.of(6),
                List.of(7, 8),
                List.of(8)
        );

        var length = adjPairList.size();

        var queue = new LinkedList<Integer>();
        queue.add(0);

        int distance[] = new int[length];
        Arrays.fill(distance, Integer.MAX_VALUE);

        while (!queue.isEmpty()) {
            var node = queue.pop();
            for (var val :adjPairList.get(node)) {
                if (distance[node] + 1 < distance[val]) {
                    distance[val] = distance[node] + 1;
                    queue.add(val);
                }
            }
        }

        for (int i = 0; i < length; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                distance[i] = -1;
            }
            System.out.print(distance[i]+ "");
        }

    }
}
