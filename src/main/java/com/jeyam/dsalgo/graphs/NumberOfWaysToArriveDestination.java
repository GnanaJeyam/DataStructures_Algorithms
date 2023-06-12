package com.jeyam.dsalgo.graphs;

import java.util.*;
import java.util.stream.IntStream;

/**
 * https://takeuforward.org/data-structure/g-40-number-of-ways-to-arrive-at-destination/
 */
public class NumberOfWaysToArriveDestination {

    public static void main(String[] args) {
        var nodeMappings = List.of(
                List.of(0,6,7),
                List.of(0,1,2),
                List.of(1,2,3),
                List.of(1,3,3),
                List.of(6,3,3),
                List.of(3,5,1),
                List.of(6,5,1),
                List.of(2,5,1),
                List.of(0,4,5),
                List.of(4,6,2)
        );

        int nodes = 7;
        int src = 0;
        int dest = 7;

        var adjList = getAdjList(nodeMappings, nodes);

        int distance[] = new int[nodes];
        int ways[] = new int[nodes];
        int mod = (int)(1e9 + 7);

        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[0] = 0;
        ways[0] = 1;

        var queue = new PriorityQueue<>(Comparator.comparing(Pair::getC));
        queue.add(new Pair(src, 0));

        while (!queue.isEmpty()) {
            var pairWithCount = queue.poll();
            var n = pairWithCount.getR();
            var edW = pairWithCount.getC();

            for (var pair : adjList.get(n)){

                var adjNode = pair.getR();
                var cost = pair.getC();

                if (distance[adjNode] > (edW + cost)) {
                    distance[adjNode] = distance[n] + cost;
                    queue.add(new Pair(adjNode, distance[adjNode] ));
                    ways[adjNode] = ways[n];

                } else if (distance[adjNode] == (edW + cost)) {
                    ways[adjNode] = (ways[adjNode] + ways[n]) % mod;
                }

            }
        }

        System.out.print(ways[dest-1] % mod);
    }

    private static List<List<Pair>> getAdjList(List<List<Integer>> nodeMappings,
                                               int nodes) {

        var adjList = new ArrayList<List<Pair>>();

        IntStream.range(0, nodes).forEach(e -> adjList.add(new ArrayList<>()));

        for (int i = 0; i < nodeMappings.size(); i++) {
            var edge = nodeMappings.get(i);
            var source = edge.get(0);
            var dest = edge.get(1);
            var cost = edge.get(2);

            var pair = adjList.get(source);
            var destPair = adjList.get(dest);

            pair.add(new Pair(dest, cost));
            destPair.add(new Pair(source, cost));
        }

        return adjList;
    }

}
