package com.jeyam.dsalgo.arrays;

import java.util.HashMap;

/**
 * https://takeuforward.org/data-structure/length-of-the-longest-subarray-with-zero-sum/
 */
public class LengthOfLongestSubArrayEqualsToZero {

    public static void main(String[] args) {
        int array[] = {9, -3, 3, -1, 6, -5};
        int max = 0;
        int sum = 0;

        var bucket = new HashMap<Integer, Integer>();
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            if (sum == 0) {
                // General sequence scenario where we will update the max with index + 1 (for zero base indexing)
                max = i+1;
            }else {
                // {1, 3, -3, 4} => If we will check whether the sum is already in the bucket
                // Updated max based on current index - previous sum index
                if (bucket.get(sum) != null) {
                    max = Math.max(max, i - bucket.get(sum));
                } else {
                    bucket.put(sum, i);
                }
            }
        }

        System.out.println(max);
    }
}
