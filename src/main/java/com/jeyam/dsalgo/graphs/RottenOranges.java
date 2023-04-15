package com.jeyam.dsalgo.graphs;

import java.util.*;

import static com.jeyam.dsalgo.graphs.GraphUtils.getColumnIndexFor4Directions;
import static com.jeyam.dsalgo.graphs.GraphUtils.getRowIndexFor4Directions;

/**
 * https://takeuforward.org/data-structure/rotten-oranges/
 */

public class RottenOranges {
    private static String COUNT = "count";

    public static void main(String[] args) {
        int oranges[][] = {
            {2, 1, 2},
            {1, 1, 0},
            {0, 2, 1}
        };

        int visited [][] = new int[oranges.length][oranges[0].length];
        var queue = new LinkedList<PairWithCount>();
        int normalOranges = 0;

        for (int i=0; i< oranges.length; i++) {
            for (int j=0; j<oranges[i].length; j++) {
                if (oranges[i][j] == 2) {
                    queue.add(new PairWithCount(i, j, 0));
                } else if (oranges[i][j] == 1) {
                    normalOranges++;
                }
            }
        }

        var result = rottenOranges(oranges, visited, queue, normalOranges);

        System.out.println(result);

    }

    private static int rottenOranges(int[][] oranges, int[][] result, Queue<PairWithCount> queue, int normalOranges) {

        boolean hasProcessed = false;
        int totalLength = oranges.length;
        int processedCount = 0;
        int rottenProcessCount = 0;

        while (!queue.isEmpty()) {
            var pair = queue.poll();
            var row = pair.getRow();
            var col = pair.getCol();
            var count = rottenProcessCount = pair.getCount();

            int rI[] = getRowIndexFor4Directions();
            int cI[] = getColumnIndexFor4Directions();

            for (int x = 0; x < 4; x++) {
                int cR = row + rI[x];
                int cC = col + cI[x];

                if (cR >= 0 && cR < totalLength && cC >= 0 && cC < totalLength &&
                    oranges[cR][cC] == 1 && result[cR][cC] != 2) {
                    result[cR][cC] = 2;
                    queue.add(new PairWithCount(cR, cC, count+1));
                    processedCount++;
                }
            }

        }

        if (normalOranges != processedCount) {
            return -1;
        }

        return rottenProcessCount;
    }
}