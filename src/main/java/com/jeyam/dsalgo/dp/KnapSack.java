package com.jeyam.dsalgo.dp;

import java.util.Arrays;

public class KnapSack {
    public static void main(String[] args) {
        int[] weights = {1, 2, 4, 5};
        int[] values = {5, 4, 8, 6};
        int k = 5;

        var knapSack = findKnapSack(3, k, weights, values);
        System.out.println("Final Result using recursion :" + knapSack);

        int[][] dp = new int[weights.length][5+1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        knapSack = findKnapSackUsingMemoization(3, k, weights, values, dp);
        System.out.println("Final Result using Memoization :" + knapSack);
    }

    private static int findKnapSack(int index,
                                    int k,
                                    int[] weights,
                                    int[] values) {

        if (index == 0) {
            if (weights[index] <= k) {
                return values[index];
            }
            return 0;
        }

        int notTake = findKnapSack(index-1, k, weights, values);
        int take = Integer.MIN_VALUE;
        if (k >= weights[index]) {
            take = values[index] + findKnapSack(index-1, k - weights[index], weights, values);
        }

        return Math.max(notTake, take);
    }

    private static int findKnapSackUsingMemoization(int index,
                                                    int k,
                                                    int[] weights,
                                                    int[] values,
                                                    int[][] dp) {

        if (index == 0) {
            if (weights[index] <= k) {
                return values[index];
            }
            return 0;
        }

        if (dp[index][weights[index]] != -1) {
            return dp[index][weights[index]];
        }

        int notTake = findKnapSack(index-1, k, weights, values);
        int take = Integer.MIN_VALUE;
        if (k >= weights[index]) {
            take = values[index] + findKnapSack(index-1, k - weights[index], weights, values);
        }


        return dp[index][weights[index]] = Math.max(notTake, take);
    }
}
