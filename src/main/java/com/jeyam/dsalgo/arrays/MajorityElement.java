package com.jeyam.dsalgo.arrays;

/**
 * https://takeuforward.org/data-structure/find-the-majority-element-that-occurs-more-than-n-2-times/
 */
public class MajorityElement {

    public static void main(String[] args) {
        int[] arr = {1,2,2,3,2};
        var result = findMajorityElement(arr);
        System.out.println("Result" + result);
    }

    private static int findMajorityElement(int[] arr) {
        int count = 0;
        int element = -1;

        for (int i = 0; i < arr.length; i++) {
            if (count == 0) {
                element = arr[i];
                count++;
            } else if (arr[i] != element) {
                count--;
            } else {
                count++;
            }
        }

        count = 0;
        // Checking if the current element count
        for (int e: arr) {
            if (e == element) {
                count++;
            }
        }

        if (count > (arr.length/2)) {
            return element;
        }

        return -1;
    }
}
