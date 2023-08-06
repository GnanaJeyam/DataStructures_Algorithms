package com.jeyam.dsalgo.arrays;

import com.jeyam.dsalgo.utils.ArrayUtils;

/**
 * https://leetcode.com/problems/maximum-subarray/solutions/
 */
public class KadaneAlgorithm {

    public static void main(String[] args) {
        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4};
        int n = arr.length;
        long maxSum = maxSubArraySum(arr, n);
        System.out.println("Result :" + maxSum);
    }

    private static long maxSubArraySum(int[] arr, int n) {
        int maxi = Integer.MIN_VALUE;
        int sum = 0;
        int startIndex = 0, endIndex = 0;

        for (int i = 0; i < n; i++) {
            sum = sum + arr[i];

            if (maxi < sum) {
                maxi = sum;
                endIndex = i;
            }

            if (sum < 0) {
                sum = 0;
                startIndex = i+1;
            }
        }

        System.out.println("Start: " + startIndex +" End: " + endIndex);
        ArrayUtils.printArray(arr, startIndex, endIndex);

        return maxi;

    }
}
