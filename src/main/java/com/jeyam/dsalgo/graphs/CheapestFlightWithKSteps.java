package com.jeyam.dsalgo.graphs;

import java.util.*;
import java.util.stream.IntStream;

/**
 * https://takeuforward.org/data-structure/g-38-cheapest-flights-within-k-stops/
 */
public class CheapestFlightWithKSteps {

    public static void main(String[] args) {

        int flights[][] = new int[][]{
                {0, 1, 100},
                {1, 2, 100},
                {2, 0, 100},
                {1, 3, 600},
                {2, 3, 200}
        };
        int nodes = 4;
        int k = 1;
        var adjList = new ArrayList<List<Pair>>();

        IntStream.range(0, nodes).forEach(e -> adjList.add(new ArrayList<>()));
        updateAdjList(flights, adjList);

        int distances[] = new int[4];
        Arrays.fill(distances, Integer.MAX_VALUE);

        distances[0] = 0;


        var queue = new LinkedList<PairWithCount>();
        queue.add(new PairWithCount(0, 0, 0));

        while (!queue.isEmpty()) {
            var pairWithCount = queue.pop();
            var node = pairWithCount.getRow();
            var dist = pairWithCount.getCol();
            var stops = pairWithCount.getCount();

            if (stops > k) {
                continue;
            }

            // We only update the queue if the new calculated dist is
            // less than the prev and the stops are also within limits.

            for (var pair : adjList.get(node)) {
                var dest = pair.getR();
                var cost = pair.getC();

                if (distances[dest] > (dist + cost) && stops <= k) {
                    distances[dest] = dist + cost;
                    queue.add(new PairWithCount(dest, distances[dest], stops+1 ));
                }
            }
        }

        System.out.print("Result " + Arrays.toString(distances));
    }

    private static void updateAdjList(int[][] flights, ArrayList<List<Pair>> adjList) {
        for (int i = 0; i < flights.length; i++) {
            var flight = flights[i];
            var source = flight[0];
            var dest = flight[1];
            var cost = flight[2];

            var pair = adjList.get(source);
            if (Objects.nonNull(pair)) {
                pair.add(new Pair(dest, cost));
            } else {
                pair = new ArrayList<>();
                pair.add(new Pair(dest, cost));

                adjList.add(source, pair);
            }
        }
    }
}
