package com.jeyam.dsalgo.graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * * https://practice.geeksforgeeks.org/problems/number-of-distinct-islands/1
 */
public class NoOfDistinctIslands {

    /**
     * To find the distinct islands we need to store the index of all row & col on an island.
     * For each cell that has value==1,  Then traverse all 4 directions.
     * Down -> Right -> Up -> Left
     * Do DFS for all cells that satisfy this condition.
     */

    public static void main(String[] args) {
        int grid[][] = {
            {1, 1, 0, 0, 0},
            {1, 1, 0, 0, 0},
            {0, 0, 0, 1, 1},
            {0, 0, 0, 1, 1}
        };

        var n = grid.length;
        var m = grid[0].length;

        boolean visited[][] = new boolean[n][m];
        var distinct = new HashSet<List<Pair>>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    var island = new ArrayList<Pair>();
                    dfs(i, j, i, j, n, m, grid, visited, island);

                    if(!island.isEmpty()) {
                        distinct.add(island);
                    }
                }
            }
        }

        System.out.println("Result: " + distinct.size());
    }

    private static void dfs(int r,
                            int c,
                            int nR,
                            int nC,
                            int n,
                            int m,
                            int[][] grid,
                            boolean[][] visited,
                            ArrayList<Pair> island) {

        visited[r][c] = true;
        island.add(new Pair(r-nR,c - nC));

        int rowIndexes[] = {-1,0,1,0};
        int colIndexes[] = {0,-1,0,1};

        for (int i = 0; i < 4; i++) {

            int currentRow = r + rowIndexes[i];
            int currentCol = c + colIndexes[i];

            if (currentRow >= 0 && currentCol >= 0 && currentRow < n && currentCol < m &&
                !visited[currentRow][currentCol] && grid[currentRow][currentCol] == 1) {
                dfs(currentRow, currentCol, nR, nC, n, m, grid, visited, island);
            }
        }
    }
}
