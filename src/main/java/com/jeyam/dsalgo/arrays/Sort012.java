package com.jeyam.dsalgo.arrays;

import static com.jeyam.dsalgo.utils.ArrayUtils.printArray;

/**
 * https://leetcode.com/problems/sort-colors/description/
 */
public class Sort012 {
    public static void main(String[] args) {
        int[] array = {2,1,0,1,0,0,1};
        int low = 0, mid = 0, high = array.length-1;
        while (mid <= high) {
            var element = array[mid];
            if (element == 0) {
                int temp = array[low];
                array[low] = element;
                array[mid] = temp;
                low++;
                mid++;
            } else if (element == 1) {
                mid++;
            } else {
                int temp = array[high];
                array[high] = element;
                array[mid] = temp;
                high--;
            }
        }

        printArray(array);

    }
}
