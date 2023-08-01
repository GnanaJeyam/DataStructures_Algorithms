package com.jeyam.dsalgo.dp;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * https://www.codingninjas.com/studio/problems/maximum-path-sum-in-the-matrix_797998
 */
public class MaximumPathSumInMatrix {

    /**
     * 10 10 2 -13 20 4
     * 1 -9 -81 30 2 5
     * 0 10 4 -79 2 -10
     * 1 -5 2 20 -11 4
     *
     * O/p: 74
     */
    public static void main(String[] args) {
        int[][] grid = {
                {-9999, -9888, -9777, -9666, -9555},
                {1, 10, 2, 4, 5},
                {-9999, -9888, -9777, -9666, -9555},
                {0, 0, 0, 0, 0},
                {-99 ,-98 ,-97 ,-96 ,-95}
        };

        int n = grid.length;
        int m = grid[0].length;

        int result = Integer.MIN_VALUE;

        for (int i = 0; i < m; i++) {
            int value = findMaxPathSum(0, i, n, m, grid);
            result = Math.max(result, value);
        }

        System.out.println("Using Recursion --> " + result);

        int dp[][] = new int[n][m];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, Integer.MIN_VALUE));
        result = Integer.MIN_VALUE;

        for (int i = 0; i < m; i++) {
            int value = findMaxPathSumUsingMemoization(0, i, n, m, grid, dp);
            result = Math.max(result, value);
        }
        System.out.println("Using Memoization --> " + result);

        result = Integer.MIN_VALUE;

        for (int i = 0; i < m; i++) {
            int value = findMaxPathSumUsingTabulation( n, m, grid, dp);
            result = Math.max(result, value);
        }
        System.out.println("Using Tabulation  --> " + result);
    }

    private static int findMaxPathSum(int i, int j, int n, int m, int[][] grid) {

        if (i == n-1 && j < m && j >= 0) {
            return grid[i][j];
        }

        if (i >= n || j >= m || i < 0 || j < 0) {
            return Integer.MIN_VALUE;
        }

        int leftDown = findMaxPathSum(i+1, j-1, n, m, grid);
        int down = findMaxPathSum(i+1, j, n, m, grid);
        int rightDown = findMaxPathSum(i+1, j+1, n, m, grid);

        return grid[i][j] + Stream.of(leftDown, down, rightDown).max(Integer::compareTo).get();
    }

    private static int findMaxPathSumUsingMemoization(int i,
                                                      int j,
                                                      int n,
                                                      int m,
                                                      int[][] grid,
                                                      int dp[][]) {

        if (i == n-1 && j < m && j >= 0) {
            return grid[i][j];
        }

        if (i >= n || j >= m || i < 0 || j < 0) {
            return Integer.MIN_VALUE;
        }

        if (dp[i][j] != Integer.MIN_VALUE) {
            return dp[i][j];
        }

        int leftDown = findMaxPathSumUsingMemoization(i+1, j-1, n, m, grid, dp);
        int down = findMaxPathSumUsingMemoization(i+1, j, n, m, grid, dp);
        int rightDown = findMaxPathSumUsingMemoization(i+1, j+1, n, m, grid, dp);

        return dp[i][j] = grid[i][j] + Stream.of(leftDown, down, rightDown).max(Integer::compareTo).get();
    }

    private static int findMaxPathSumUsingTabulation(int n,
                                                     int m,
                                                     int[][] grid,
                                                     int dp[][]) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i ==0) {
                    dp[0][j] = grid[i][j];
                }else {
                    int leftDown = Integer.MIN_VALUE;
                    int rightDown = Integer.MIN_VALUE;
                    int down = Integer.MIN_VALUE;

                    if (i+1 < n && j-1 >=0) {
                        leftDown = grid[i+1][j-1];
                    }
                    if (i+1 < n) {
                        rightDown = grid[i+1][j];
                    }
                    if (i+1 < n && j+1 < m) {
                        down = grid[i+1][j+1];
                    }

                    dp[i][j] = grid[i][j] + Stream.of(leftDown, down, rightDown).max(Integer::compareTo).get();
                }
            }
        }

        return dp[n-1][m-1];

    }

}
