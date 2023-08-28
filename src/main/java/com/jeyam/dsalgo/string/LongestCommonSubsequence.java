package com.jeyam.dsalgo.string;

import com.jeyam.dsalgo.utils.ArrayUtils;

import java.util.Arrays;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        String a = "sqabs";
        String b = "zaxbm";

        System.out.println("Result " + findLCS(0, 0, a, b));

        int[][] dp = new int[a.length()+1][b.length()+1];
        Arrays.stream(dp).forEach(ar -> Arrays.fill(ar, -1));
        System.out.println("Result Using Memo " + findLCSUsingMemo(0, 0, a, b, dp));

        Arrays.stream(dp).forEach(ar -> Arrays.fill(ar, 0));
        System.out.println("Using tab " + findLCSUsingTabulation(a, b, dp) );
    }

    private static int findLCS(int i, int j, String a, String b) {
        if (i == a.length() || j == b.length()) {
            return 0;
        }

        if (a.charAt(i) == b.charAt(j)) {
            return 1 + findLCS(i+1, j+1, a, b);
        }

        return Math.max(findLCS(i, j+1, a, b) , findLCS(i+1, j, a, b));
    }

    private static int findLCSUsingMemo(int i, int j, String a, String b, int dp[][]) {
        if (i == a.length() || j == b.length()) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (a.charAt(i) == b.charAt(j)) {
            return 1 + findLCSUsingMemo(i+1, j+1, a, b, dp);
        }

        return dp[i][j] =  Math.max(
                findLCSUsingMemo(i, j+1, a, b, dp) ,
                findLCSUsingMemo(i+1, j, a, b, dp)
        );
    }

    private static int findLCSUsingTabulation(String a, String b, int dp[][]) {

        for (int i = 1; i <=a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                if (a.charAt(i-1) == b.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[a.length()][b.length()];
    }
}
