package com.jeyam.dsalgo.arrays;

import java.util.HashSet;

/**
 * https://takeuforward.org/data-structure/longest-consecutive-sequence-in-an-array/
 */
public class LongestSuccessiveElements {
    public static void main(String[] args) {
        int a[] = {1, 2, 2, 1};
        var bucket = new HashSet<>();
        int maxCount = -1;
        int count;

        /**
         * 1. Add all elements from the array to HashSet
         * 2. Then we need to check initial seq number from the hashset.
         *  Ex: The array can contain numbers like 3, 1, 2 or 90, 91, 92
         * 3. Based on above example we will identify the starting number (i.e 1 and 90)
         * and then increment that numbers and check if it in the set based on that
         * increment the count.
         * 4. After that update the maxCount based on count.
         *
         * TC: O(N) + O(2*N) ~ O(3*N), where N = size of the array.
         * SC: O(N)
         */

        for (int i : a) {
            bucket.add(i);
        }

        for (int i : a) {
            if (!bucket.contains(i-1)) {
                int t = i;
                count = 1;
                while (bucket.contains(t+1)) {
                    count++;
                    t++;
                }
                maxCount = Math.max(maxCount, count);
            }
        }


        System.out.println(maxCount);
    }
}
