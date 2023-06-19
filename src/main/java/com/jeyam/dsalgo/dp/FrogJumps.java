package com.jeyam.dsalgo.dp;

import java.util.Arrays;

/**
 * https://takeuforward.org/data-structure/dynamic-programming-frog-jump-dp-3/
 */
public class FrogJumps {
    public static void main(String[] args) {
        int height[]={30,10,60 , 10 , 60 , 50};
        int n = height.length;
        int dp[] = new int[n+1];

        // Using recursion memoization
        Arrays.fill(dp, -1);
        int result = frogJump(n-1, height, dp);
        System.out.println("Result using recursion :" + result);

        // Using tabulation method
        Arrays.fill(dp, -1);
        result = frogJumpUsingTabulation(n-1, height, dp);
        System.out.println("Result using tabulation:" + result);

        // Space Optimised
        System.out.print("Space optimized: " + frogJumpOptimized(n-1, height));
    }

    static int frogJump(int n, int height[], int dp[]) {
        if (n == 0) {
            return 0;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        int left = frogJump(n-1, height, dp) + Math.abs(height[n] - height[n-1]);

        // If the n is 1, then performing n-2 will result in -1
        // To avoid that we are checking the condition.

        int right = Integer.MAX_VALUE;
        if (n > 1) {
            right = frogJump(n-2, height, dp) + Math.abs(height[n] - height[n-2]);
        }

        return dp[n] = Math.min(left, right);
    }

    static int frogJumpUsingTabulation(int n, int height[], int dp[]) {
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            int left = dp[i -1 ] + Math.abs(height[i] - height[i-1]);
            int right = Integer.MAX_VALUE;
            if (i > 1) {
                right = dp[i- 2] + Math.abs(height[i] - height[i-2]);
            }
            dp[i] = Math.min(left, right);
        }

        return dp[n];
    }

    static int frogJumpOptimized(int n, int height[]) {
        int prevPre = 0;
        int prevI = 0;
        int curr = 0;

        for (int i = 1; i <= n; i++) {
            int jumpOne = prevI + Math.abs(height[i] - height[i-1]);
            int jumpTwo = Integer.MAX_VALUE;

            if (i > 1) {
                jumpTwo = prevPre + Math.abs(height[i] - height[i-2]);
            }

            curr = Math.min(jumpOne, jumpTwo);
            prevPre = prevI;
            prevI = curr;
        }

        return curr;
    }
}
