package com.jeyam.dsalgo.dp;

import java.util.Arrays;

public class MinimumPathSum {

    public static void main(String[] args) {
        int[][] grid = {
            {1, 20, 60, 50},
            {30, 10, 40, 5},
            {70, 80, 10, 45},
            {25, 15, 35, 55}
        };
        int m = grid.length;
        int n = grid[0].length;

        var result = findMinPathSum(m - 1, n - 1, grid);
        System.out.println("Using Recursion: " + result);

        int[][] dp = new int[m][n];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        result = findMinPathSumUsingMemoization(m - 1, n - 1, grid, dp);
        System.out.println("Using Memoization: " + result);

        result = findMinPathSumUsingTabulation(grid, dp);
        System.out.println("Using Tabulation: " + result);
    }

    private static int findMinPathSum(int i, int j, int[][] grid) {
        if (i == 0 && j == 0) {
            return grid[0][0];
        }

        if (i < 0 || j < 0) {
            return Integer.MAX_VALUE;
        }

        int left = findMinPathSum(i, j-1, grid);
        int up = findMinPathSum(i-1, j, grid);

        return grid[i][j] + Math.min(left, up);
    }

    private static int findMinPathSumUsingMemoization(int i, int j, int[][] grid, int[][] dp) {
        if (i == 0 && j == 0) {
            return grid[0][0];
        }

        if (i < 0 || j < 0) {
            return Integer.MAX_VALUE;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int left = findMinPathSumUsingMemoization(i, j-1, grid, dp);
        int up = findMinPathSumUsingMemoization(i-1, j, grid, dp);

        return dp[i][j] = grid[i][j] + Math.min(left, up);
    }
    private static int findMinPathSumUsingTabulation(int[][] grid, int[][] dp) {

        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[i].length; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[0][0];
                } else {
                    int left = Integer.MAX_VALUE;
                    int up = Integer.MAX_VALUE;
                    if (j > 0) {
                        left = dp[i][j-1];
                    }
                    if (i > 0) {
                        up = dp[i-1][j];
                    }

                    dp[i][j] = grid[i][j] + Math.min(left, up);
                }

            }
        }

        return dp[grid.length-1][grid[0].length-1];
    }
}
