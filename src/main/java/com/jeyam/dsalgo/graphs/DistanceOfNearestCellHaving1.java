package com.jeyam.dsalgo.graphs;

import java.util.LinkedList;

import static com.jeyam.dsalgo.graphs.GraphUtils.*;

public class DistanceOfNearestCellHaving1 {
    public static void main(String[] args) {
        int grid[][] = {
            {0, 0, 0},
            {0, 1, 0},
            {1, 0, 1}
        };
        System.out.println("Input: ");
        printMatrix(grid);

        var n = grid.length;
        var m = grid[0].length;

        boolean visited [][] = new boolean[n][m];
        int result [][] = new int[n][m];

        var queue = new LinkedList<PairWithCount>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new PairWithCount(i, j, 0));
                    visited[i][j] = true;
                    result[i][j] = 0;
                }
            }
        }

        detectDistance(grid, result,  visited, queue, n, m);
        System.out.println("Output: ");
        printMatrix(result);
    }

    private static void detectDistance(int[][] grid,
                                       int[][] result,
                                       boolean[][] visited,
                                       LinkedList<PairWithCount> queue,
                                       int rowLength,
                                       int colLength) {
        while (!queue.isEmpty()) {
            var pairWithCount = queue.pop();
            var row = pairWithCount.getRow();
            var col = pairWithCount.getCol();
            var count = pairWithCount.getCount();

            int rI[] = getRowIndexFor4Directions();
            int cI[] = getColumnIndexFor4Directions();

            for (int x = 0; x < 4; x++) {
                int cR = row + rI[x];
                int cC = col + cI[x];
                if (cR >= 0 && cC >= 0 && cR < rowLength && cC < colLength &&
                    !visited[cR][cC]) {
                    queue.add(new PairWithCount(cR, cC, count + 1));
                    visited[cR][cC] = true;
                    result[cR][cC] = count + 1;
                }
            }
        }
    }


}
