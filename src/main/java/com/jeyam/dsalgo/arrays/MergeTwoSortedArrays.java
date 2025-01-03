package com.jeyam.dsalgo.arrays;

import com.jeyam.dsalgo.utils.ArrayUtils;

import java.util.Arrays;

/**
 * https://takeuforward.org/data-structure/merge-two-sorted-arrays-without-extra-space/
 */
public class MergeTwoSortedArrays {

    public static void main(String[] args) {

        int[] first = {1, 4, 8, 10,0, 0, 0};
        int[] second = {2, 3, 9};

        /**
         * For this approach you have to add dummy 0 values in the first array of second array size
         * TC: O(m + n)
         * SC: O(1)
         */
        mergeInPlace(first, first.length - second.length, second, second.length);

        ArrayUtils.printArray(first);

    }

    public static void mergeInPlace(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1; // Last index of nums1's initial elements
        int j = n - 1; // Last index of nums2
        int k = m + n - 1; // Last index of nums1 (with extra space)

        // Merge from the back
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        // Add remaining elements from nums2 (if any)
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}
