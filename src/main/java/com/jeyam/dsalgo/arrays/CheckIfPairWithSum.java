package com.jeyam.dsalgo.arrays;

import java.util.Arrays;

public class CheckIfPairWithSum {

    public static void main(String[] args) {
        int[] arr = {2,6,5,8,11};
        int end = arr.length-1;
        int start = 0;
        int target = 14;
        int[] result = {-1, -1};

        while (start < end) {
            var pair = arr[start] + arr[end];
            if (pair < target) {
                start++;
            } else if(pair > target) {
                end--;
            } else {
                result[0] = start;
                result[1] = end;
                break;
            }
        }

        System.out.println("Result: " + Arrays.toString(result));
    }
}
