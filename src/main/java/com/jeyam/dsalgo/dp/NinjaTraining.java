package com.jeyam.dsalgo.dp;

import java.util.Arrays;

public class NinjaTraining {
    public static void main(String[] args) {
        int [][] points = new int[][] {
                {10, 40, 70},
                {20, 50, 80},
                {30, 60, 90}
        };

        var length = points.length;
        var result = calculateNinjaTraining(points, 0, length, -1);
        System.out.println("Result using recursion -- " + result);

        int [][]dp = new int[length][3];
        for (int i = 0; i < length; i++) {
            Arrays.fill(dp[i], -1);
        }

        result = calculateNinjaTrainingUsingMemoization(points, 0, length, -1, dp);
        System.out.println("Result using memoization -- " + result);
    }

    static int calculateNinjaTraining(int [][] points, int day, int n, int prevElement) {
        if (day == n-1) {
            var point = points[n - 1];
            return findMax(point, prevElement);
        }

        int max = 0;
        for (int i = 0; i < 3; i++) {
            if (i == prevElement) {
                // Skip the logic
                continue;
            }
            var point = points[day];
            var current = point[i] + calculateNinjaTraining(points, day+1, n, i );
            max = Math.max(max, current);
        }

        return max;
    }

    static int calculateNinjaTrainingUsingMemoization(int [][] points, int day, int n, int prevElement, int [][]dp) {
        if (day == n-1) {
            var point = points[n - 1];
            return findMax(point, prevElement);
        }

        int max = 0;
        if (prevElement != -1 && dp[day][prevElement] != -1) {
            return dp[day][prevElement];
        }

        for (int i = 0; i < 3; i++) {
            if (i == prevElement) {
                // Skip the logic
                continue;
            }
            var point = points[day];
            var current = point[i] + calculateNinjaTrainingUsingMemoization(points, day+1, n, i,  dp);
            dp[day][i] = current;
            max = Math.max(max, current);
        }

        return max;
    }

    private static int findMax(int[] point, int prevElement) {
        int low = 0;
        for (int i = 0; i < 3; i++) {
            if (i != prevElement) {
                low = Math.max(low, point[i]);
            }
        }

        return low;
    }
}
