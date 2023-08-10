package com.jeyam.dsalgo.arrays;

import com.jeyam.dsalgo.utils.ArrayUtils;

import java.util.Arrays;

/**
 * https://takeuforward.org/data-structure/merge-two-sorted-arrays-without-extra-space/
 */
public class MergeTwoSortedArrays {

    public static void main(String[] args) {
        int[] first = {1, 4, 8, 10};
        int[] second = {2, 3, 9};

        //optimalApproach1(first.clone(), second.clone());
        optimalApproach2(first, second);
    }

    private static void optimalApproach2(int[] first, int[] second) {
        /**
         * TC: O((n+m)*log(n+m))
         * SC: 0(1)
         */
        int n = first.length;
        int m = second.length;
        int length = n + m;
        // If we have a decimal pointer let say 9/2=4.5, In this case we need to round off to 5
        int gap = (length / 2) + (length % 2);

        while (gap > 0) {
            int left = 0;
            int right = left + gap;
            while (right < length) {
                // If left in arr1 and right in arr2
                if (left < n && right >=n ) {
                    swapIfGreater(first, second, left, right-n);
                }
                // If left and right in arr2
                else if (left >= n) {
                    swapIfGreater(second, second, left-n, right-n);
                }
                // If left in arr1 and right in arr1
                else {
                    swapIfGreater(first, first, left, right);
                }

                left++;
                right++;
            }

            if (gap == 1) {
                break;
            }

            gap = (gap/2) + (gap % 2);
        }

        ArrayUtils.printArray(first);
        ArrayUtils.printArray(second);
    }

    private static void swapIfGreater(int[] arr1, int[] arr2, int n, int m) {
        if (arr1[n] > arr2[m]) {
            int temp = arr1[n];
            arr1[n] = arr2[m];
            arr2[m] = temp;
        }
    }

    private static void optimalApproach1(int[] first, int[] second) {
        /**
         * TC: O(min(n, m)) + O(n logn) + O(m log m)
         * SC: 0
         */
        int firstEnd = first.length-1;
        int secondStart = 0;

        while (firstEnd >=0 && secondStart < second.length) {
            if (first[firstEnd] > second[secondStart]) {
                int temp = first[firstEnd];
                first[firstEnd] = second[secondStart];
                second[secondStart] = temp;
                secondStart++;
                firstEnd--;
            } else  {
                break;
            }
        }

        Arrays.sort(first);
        Arrays.sort(second);

        ArrayUtils.printArray(first);
        ArrayUtils.printArray(second);
    }
}
