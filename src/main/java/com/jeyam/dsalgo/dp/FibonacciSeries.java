package com.jeyam.dsalgo.dp;



import static java.util.Arrays.fill;

/**
 * https://takeuforward.org/data-structure/dynamic-programming-introduction/
 */
public class FibonacciSeries {
    public static void main(String[] args) {
        int dp[] = new int[6];

        // Using Recursion memoization method
        fill(dp, -1);
        System.out.println("Using Recursion Memo " + fib(5, dp));

        // Using tabulation method
        fill(dp, -1);
        System.out.println("Using Tabulation " + fibUsingTabulationMethod(5, dp));

        // Optimized approach
        System.out.println("Optimized approach " + fibOptimized(5));
    }

    private static int fib(int n, int dp[]) {
        if (n <= 1) {
            return n;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        return dp[n] = fib(n-1, dp) + fib(n-2, dp);
    }

    private static int fibUsingTabulationMethod(int n, int dp[]) {
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }

    private static int fibOptimized(int n) {
        int prev = 1;
        int prePrev = 0;
        int current = 0;

        for (int i = 2; i <= n; i++) {
            current = prev + prePrev;
            prePrev = prev;
            prev = current;
        }

        return current;
    }
}
