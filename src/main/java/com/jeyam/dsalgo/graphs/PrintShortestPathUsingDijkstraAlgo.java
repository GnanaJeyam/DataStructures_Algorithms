package com.jeyam.dsalgo.graphs;

import java.util.*;

/**
 * * https://takeuforward.org/data-structure/g-35-print-shortest-path-dijkstras-algorithm/
 */
public class PrintShortestPathUsingDijkstraAlgo {

    public static void main(String[] args) {

        int edges[][] = new int[][] {
            {1,2,2},
            {2,5,5},
            {2,3,4},
            {1,4,1},
            {4,3,3},
            {3,5,1}
        };

        // Converting edges array to adjMap.
        var adjMap = new HashMap<Integer, List<Pair>>();

        for (int i = 0; i < edges.length; i++) {
            var edge = edges[i];
            var pairs = adjMap.get(edge[0]);
            if (Objects.isNull(pairs)) {
                var newPair = new ArrayList<Pair>();
                newPair.add(new Pair(edge[1], edge[2]));
                adjMap.put(edge[0], newPair);
            } else {
                pairs.add(new Pair(edge[1], edge[2]));
            }
        }

        int distance[] = new int[6];
        int parent[] = new int[6];

        for (int i = 1; i < parent.length; i++) {
            distance[i] = Integer.MAX_VALUE;
            parent[i] = i;
        }

        distance[1] = 0;

        var priorityQueue = new PriorityQueue<>(Comparator.comparing(Pair::getC));
        priorityQueue.add(new Pair(1, 0));

        while (!priorityQueue.isEmpty()) {
            var pair = priorityQueue.poll();
            var node = pair.getR();
            var weight = pair.getC();

            var list = adjMap.get(node);
            if (Objects.nonNull(list)) {
                for (var adj : list) {
                    var adjNode = adj.getR();
                    var adjWeight = adj.getC();

                    if ( distance[adjNode] > distance[node] + adjWeight ) {
                        distance[adjNode] = distance[node] + adjWeight;
                        parent[adjNode] = node;
                        priorityQueue.add(new Pair(adjNode, distance[node] + adjWeight));
                    }
                }
            }
        }

        int node = 5;

        var result = new ArrayList<Integer>();


        while (parent[node] != node) {
            result.add(node);
            node = parent[node];
        }

        result.add(1);
        Collections.reverse(result);

        System.out.print(result);
    }
}
