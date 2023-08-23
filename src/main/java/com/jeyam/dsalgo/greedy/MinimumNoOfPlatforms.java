package com.jeyam.dsalgo.greedy;

import java.util.Arrays;

/**
 * https://practice.geeksforgeeks.org/problems/minimum-platforms-1587115620/1
 */
public class MinimumNoOfPlatforms {
    public static void main(String[] args) {
        int[] arr ={900,945,955,1100,1500,1800};
        int[] dep={920,1200,1130,1150,1900,2000};

        Arrays.sort(arr);
        Arrays.sort(dep);

        // 900, 945, 955, 1100, 1500, 1800
        // 920, 1130, 1150, 1200, 1900, 2000

        /**
         * TC: O(N logN) + O(N logN) + 2O(N)
         * SC: O(1)
         */
        int n=arr.length;
        int count = 1, max = 1;
        int i = 1, j=0;
        while (i < n && j < n) {
            if (dep[j] >= arr[i]) {
                count++;
                i++;
            } else {
                count--;
                j++;
            }
            max = Math.max(max, count);
        }

        System.out.println(max);
    }
}
