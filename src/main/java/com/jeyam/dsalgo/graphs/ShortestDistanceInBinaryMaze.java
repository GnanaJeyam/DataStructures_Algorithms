package com.jeyam.dsalgo.graphs;

import java.util.LinkedList;

public class ShortestDistanceInBinaryMaze {

    public static void main(String[] args) {
        int binary [][] = {
            {1, 1, 1, 1},
            {1, 1, 0, 1},
            {1, 1, 1, 1},
            {1, 1, 0, 0},
            {1, 0, 0, 1}
        };

        int source[] = {0, 1};
        int dest [] = {2, 2};

        var n = binary.length;
        var m = binary[0].length;
        boolean visited [][] = new boolean[n][m];

        var queue = new LinkedList<PairWithCount>();
        queue.add(new PairWithCount(source[0], source[1], 0 ));

        var pathCost = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            var pairWithCount = queue.pop();
            var r = pairWithCount.getRow();
            var c = pairWithCount.getCol();

            visited[r][c] = true;
            var count = pairWithCount.getCount();

            if (dest[0] == r && dest[1] == c) {
                if (count < pathCost) {
                    pathCost = count;
                }
            }

            int rowIndex[] = new int[]{0, 0, -1, 1};
            int colIndex[] = new int[]{-1, 1, 0, 0};

            for (int i = 0; i < 4; i++) {
                int cR = rowIndex[i] + r;
                int cC = colIndex[i] + c;

                if (cR < n && cC < m && cR > -1 && cC > -1 && !visited[cR][cC] && binary[cR][cC] == 1) {
                    queue.add(new PairWithCount(cR, cC, count+1));
                }
            }
        }

        if (pathCost == Integer.MAX_VALUE) {
            pathCost = -1;
        }

        System.out.print("Distance:  " + pathCost);
    }
}
