package com.jeyam.dsalgo.dp;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/house-robber/description/
 * https://www.codingninjas.com/studio/problems/maximum-sum-of-non-adjacent-elements_84326
 */
public class MaximumSumOfNonAdjacentElements {

    public static void main(String[] args) {
        int nums[] = new int[] {2,7,9,3,1};
        int index = nums.length - 1;

        // Recursion
        System.out.println("Recursion -> "+ rob(index, nums));

        // Memoization
        int dp[] = new int[nums.length];
        Arrays.fill(dp, -1);
        System.out.println("Using Memoization -> " + robUsingMemoization(index, nums, dp));

        // Using Tabulation
        System.out.println("Using tabulation -> " + robUsingTabulation(nums) );
    }

    private static int rob(int index, int nums[]) {
        if (index < 0) return 0;
        if (index == 0) return nums[index];

        int pick = nums[index] + rob(index-2, nums);
        int notPick = rob(index - 1, nums);

        return Math.max(pick, notPick);
    }

    private static int robUsingMemoization(int index, int nums[], int dp[]) {
        if (index < 0) return 0;
        if (index == 0) return nums[index];
        if (dp[index] != -1) return dp[index];

        int pick = nums[index] + robUsingMemoization(index-2, nums, dp);
        int notPick = robUsingMemoization(index - 1, nums, dp);

        return dp[index] = Math.max(pick, notPick);
    }

    private static int robUsingTabulation(int nums[]) {
        int prev2 = 0;
        int prev = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int pick = nums[i] + prev2;
            int notPick = prev;
            int current = Math.max(pick, notPick);
            prev2 = prev;
            prev = current;
        }

        return prev;
    }
}
