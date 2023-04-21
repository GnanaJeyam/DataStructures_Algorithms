package com.jeyam.dsalgo.graphs;

import java.util.LinkedList;

/**
 * * https://takeuforward.org/graph/number-of-enclaves/
 */
public class NumberOfEnclaves {
    public static void main(String[] args) {
        int grid [][] = {
            {0, 0, 0, 0},
            {0, 1, 1, 0},
            {0, 1, 1, 0},
            {0, 0, 0, 0}
        };
        var n = grid.length;
        var m = grid[0].length;
        boolean visited[][] = new boolean[n][m];
        var queue = new LinkedList<Pair>();

        findEnclaves(grid, n, m, visited, queue);
    }


    private static void findEnclaves(int[][] grid,
                                     int n,
                                     int m,
                                     boolean[][] visited,
                                     LinkedList<Pair> queue) {

        /**
         * Traverse all 4 directions of boundary.
         * Top -> Bottom -> Up -> Down
         */

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0 || i == n-1 || j == m-1) {
                    if (grid[i][j] == 1) {
                        queue.add(new Pair(i, j));
                    }
                }
            }
        }

        /**
         * Find all neighbouring 1's and mark it as visited.
         */
        while (!queue.isEmpty()) {
            var pair = queue.pop();
            var row = pair.getR();
            var col = pair.getC();

            visited[row][col] = true;

            int rowIdx[] = {-1, 0, 1, 0};
            int colIdx[] = {0, 1, 0, -1};

            for (int i = 0; i < 4; i++) {
                int rowDir = row + rowIdx[i];
                int colDir = col + colIdx[i];

                if(rowDir >= 0 && colDir >= 0 && rowDir < n && colDir < m &&
                   !visited[rowDir][colDir] && grid[rowDir][colDir] == 1) {
                    queue.add(new Pair(rowDir, colDir));
                }
            }
        }

        var totalEnclaves = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    totalEnclaves++;
                }
            }
        }

        System.out.println("Total Enclaves: " + totalEnclaves);
    }
}
