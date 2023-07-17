package com.jeyam.dsalgo.dp;

import java.util.Arrays;

public class GridUniquePaths {
    public static void main(String[] args) {
        int m = 4;
        int n = 3;

        int result = findUniquePathsInGrid(m,n);
        System.out.println("Using Recursion: " + result);

        int dp[][] = new int[m+1][n+1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        result = findUniquePathsInGridUsingMemoization(m, n, dp);
        System.out.println("Using DP Memoization: " + result);
    }

    private static int findUniquePathsInGrid(int i, int j) {
        if (i == 1 && j == 1) {
            return 1;
        }

        if (i < 0 || j < 0) {
            return 0;
        }

        int left = findUniquePathsInGrid(i, j-1);
        int up = findUniquePathsInGrid(i-1, j);

        return up + left;
    }

    private static int findUniquePathsInGridUsingMemoization(int i, int j, int dp[][]) {
        if (i == 1 && j == 1) {
            return 1;
        }

        if (i < 0 || j < 0) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int left = findUniquePathsInGridUsingMemoization(i, j-1, dp);
        int up = findUniquePathsInGridUsingMemoization(i-1, j, dp);

        return dp[i][j] = up + left;
    }
}
