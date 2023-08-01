package com.jeyam.dsalgo.dp;

import java.util.Arrays;

/**
 * https://www.codingninjas.com/studio/problems/ways-to-make-coin-change_630471
 */
public class CoinChange {

    public static void main(String[] args) {
        int[] coins = {1, 2, 3};
        int target = 4;

        System.out.println("Using Recursion -> " + findCoinChangeCombinations(coins.length-1, target, coins));

        int[][] dp = new int[coins.length][target+1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));

        System.out.println("Using Memoization -> " + findCoinChangeCombinationsUsingMemoization(coins.length-1, target, coins, dp));
    }

    static int findCoinChangeCombinations(int index, int target, int[] coins) {

        if (target == 0) {
            return 1;
        } else if (target < 0) {
            return 0;
        }

        if (index == 0) {
            if (target % coins[0] == 0) {
                return 1;
            }

            return 0;
        }

        int notTake = findCoinChangeCombinations(index-1, target, coins);
        int take = 0;

        if (target >= coins[index]) {
            take = findCoinChangeCombinations(index, target-coins[index], coins);
       }

        return  notTake + take;
    }

    static int findCoinChangeCombinationsUsingMemoization(int index, int target, int[] coins, int[][] dp) {
        if (index == 0) {
            if (target % coins[0] == 0) {
                return 1;
            }

            return 0;
        }

        if (dp[index][target] != -1) {
            return dp[index][target];
        }

        int notTake = findCoinChangeCombinationsUsingMemoization(index-1, target, coins, dp);
        int take = 0;

        if (target >= coins[index]) {
            take = findCoinChangeCombinationsUsingMemoization(index, target-coins[index], coins, dp);
        }

        return  dp[index][target] = notTake + take;
    }
}
