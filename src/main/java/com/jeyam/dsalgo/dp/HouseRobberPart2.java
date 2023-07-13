package com.jeyam.dsalgo.dp;

import java.util.ArrayList;
import java.util.Arrays;

public class HouseRobberPart2 {

    public static void main(String[] args) {
        Integer[] valuesInHouse = new Integer[] {2, 3, 2};
        int n = valuesInHouse.length;

        var valuesWithFirst = new ArrayList<Integer>();
        var valuesWithLast = new ArrayList<Integer>();

        for (int i = 0; i < valuesInHouse.length; i++) {
            if (i != valuesInHouse.length-1) {
                valuesWithFirst.add(valuesInHouse[i]);
            }
            if (i != 0) {
                valuesWithLast.add(valuesInHouse[i]);
            }
        }

        var valuesWithFirstArray = valuesWithFirst.toArray(new Integer[0]);
        var valuesWithLastArray = valuesWithLast.toArray(new Integer[0]);


        var result = Math.max(
                robHouse(n - 2, valuesWithFirstArray),
                robHouse(n - 2, valuesWithLastArray
        ));
        System.out.println("Using Recursion: " + result);

        long [] dp = new long[valuesWithLastArray.length];
        Arrays.fill(dp, -1);
        var pick = robHouseUsingMemoization(n - 2, valuesWithFirstArray, dp);
        Arrays.fill(dp, -1);
        var NotPick = robHouseUsingMemoization(n - 2, valuesWithLastArray, dp);
        result = Math.max(pick, NotPick);
        System.out.println("Using Memoization: " + result);
    }

    static String test() throws Exception {
        throw new Exception();
    }
    static long robHouse(int n, Integer[] values) {
        if (n == 0) {
            return values[0];
        }

        if (n < 0) {
            return 0;
        }

        long pick = values[n] + robHouse(n-2, values);
        long notPick = robHouse(n-1, values);

        return Math.max(pick, notPick);
    }

    static long robHouseUsingMemoization(int n, Integer[] values, long dp[]) {
        if (n == 0) {
            return values[0];
        }

        if (n < 0) {
            return 0;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        long pick = values[n] + robHouse(n-2, values);
        long notPick = robHouse(n-1, values);

        return dp[n] = Math.max(pick, notPick);
    }
}
