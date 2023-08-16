package com.jeyam.dsalgo.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * https://takeuforward.org/data-structure/majority-elementsn-3-times-find-the-elements-that-appears-more-than-n-3-times-in-the-array/
 */
public class MajorityElementForNBy3 {

    public static void main(String[] args) {
        int[] arr = {11,33,33,11,33,11};
        var result = findMajorityElement(arr);
        System.out.println("Result" + result);
    }

    private static List<Integer> findMajorityElement(int[] arr) {
        int count = 0;
        int count2 = 0;
        int element = -1;
        int element2 = -1;

        for (int j : arr) {
            if (count == 0 && j != element) {
                element = j;
                count++;
            } else if (count2 == 0 && j != element2) {
                element2 = j;
                count2++;
            } else if (element2 == j) {
                count2++;
            } else if (element == j) {
                count++;
            } else {
                count--;
                count2--;
            }
        }

        count = 0;
        count2 = 0;
        // Checking if the current element count
        for (int e: arr) {
            if (e == element) {
                count++;
            } else if (e == element2) {
                count2++;
            }
        }

        var result = new ArrayList<Integer>();
        if (count > (arr.length/3)) {
            result.add(element);
        }
        if (count2 > (arr.length/3)) {
            result.add(element2);
        }

        return result;
    }
}
