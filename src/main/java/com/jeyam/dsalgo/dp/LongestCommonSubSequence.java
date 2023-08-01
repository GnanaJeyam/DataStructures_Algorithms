package com.jeyam.dsalgo.dp;

import java.util.Arrays;

/**
 * https://takeuforward.org/data-structure/longest-common-subsequence-dp-25/
 */
public class LongestCommonSubSequence {
    public static void main(String[] args) {
        var l = "adebc";
        var r = "dcadb";

        var lIndex = l.length()-1;
        var rightIndex = r.length()-1;
        System.out.println("Using Recursion " + findLongestSeqLength(lIndex, rightIndex, l, r));

        int[][] dp = new int[lIndex+1][rightIndex+1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        System.out.println("Using Memoization " + findLongestSeqLengthUsingMemoization(lIndex, rightIndex, l, r, dp));
    }

    static int findLongestSeqLength(int lIndex, int rIndex, String left, String right) {
        if (lIndex < 0 || rIndex < 0) {
            return 0;
        }

        // If both are same character, then reduce both the pointers by 1

        if (left.charAt(lIndex) == right.charAt(rIndex)) {
            return 1 + findLongestSeqLength(lIndex-1, rIndex-1, left, right);

        } else {
            /*
             * If both the characters are not same, then try both the options like first reducing
             * one index and next reducing the other index. Finally, pick the max from these 2.
             *
             */


            return Math.max(
                    findLongestSeqLength(lIndex-1, rIndex, left, right),
                    findLongestSeqLength(lIndex, rIndex-1, left, right)
            );
        }

    }

    static int findLongestSeqLengthUsingMemoization(int lIndex, int rIndex, String left, String right, int dp[][]) {
        if (lIndex < 0 || rIndex < 0) {
            return 0;
        }

        if (dp[lIndex][rIndex] != -1) {
            return dp[lIndex][rIndex];
        }

        // If both are same character, then reduce both the pointers by 1
        if (left.charAt(lIndex) == right.charAt(rIndex)) {
            return dp[lIndex][rIndex] = 1 + findLongestSeqLength(lIndex-1, rIndex-1, left, right);

        } else {
            /*
             * If both the characters are not same, then try both the options like first reducing
             * one index and next reducing the other index. Finally, pick the max from these 2.
             */

            return dp[lIndex][rIndex] =  Math.max(
                    findLongestSeqLength(lIndex-1, rIndex, left, right),
                    findLongestSeqLength(lIndex, rIndex-1, left, right)
            );
        }

    }
}
