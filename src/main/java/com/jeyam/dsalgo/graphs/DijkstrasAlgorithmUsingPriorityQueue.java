package com.jeyam.dsalgo.graphs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * https://takeuforward.org/data-structure/dijkstras-algorithm-using-priority-queue-g-32/
 */

public class DijkstrasAlgorithmUsingPriorityQueue {

    // Note: The Graph doesn’t contain any negative weight cycle.
    public static void main(String[] args) {

        var adjList = new ArrayList<>(
            List.of(
                List.of(new Pair(1, 9)),
                List.of(new Pair(0, 9))
            ));
        var vertices = adjList.size();
        var startNode = 0;

        int distance[] = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[startNode] = 0;

        var priorityQueue = new PriorityQueue<>(Comparator.comparingInt(Pair::getC));
        priorityQueue.add(new Pair(startNode, 0));

        while (!priorityQueue.isEmpty()) {
            var pair = priorityQueue.poll();
            var node = pair.getR();
            var weight = pair.getC();

            for (var neighbourNode: adjList.get(node)) {
                if (distance[neighbourNode.getR()] > weight + neighbourNode.getC()) {
                    distance[neighbourNode.getR()] = weight + neighbourNode.getC();
                    priorityQueue.add(new Pair(neighbourNode.getR(), distance[neighbourNode.getR()]));
                }
            }
        }

        for (int i = 0; i < vertices; i++) {
            System.out.print(" " + distance[i]);
        }
    }
}
