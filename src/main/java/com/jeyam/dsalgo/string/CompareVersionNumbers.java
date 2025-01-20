package com.jeyam.dsalgo.string;

/**
 * https://leetcode.com/problems/compare-version-numbers/description/
 */
public class CompareVersionNumbers {

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 10, 0, 1, 2, 3};

        int low = 0;
        int high = arr.length -1 ;
        int max = -1;
        while (low <= high) {
            int mid = (low + high)/2;
            if (arr[low] <= arr[high]) {
                max = Math.max(max, arr[high]);
                break;
            }

            if (arr[low] <= arr[mid]) {
                max = Math.max(max, arr[mid]);
                low = mid + 1;
            } else if (arr[mid] <= arr[high]) {
                max = Math.max(max, arr[high]);
                high = mid - 1;
            }
        }

        System.out.println("MAX " + max);

        int result = compareVersion("1.01", "1.001");
        System.out.println("Result " + result);
    }

    private static int compareVersion(String version1, String version2) {
        int i = 0;
        int j = 0;

        while (i < version1.length() || j < version2.length()) {
            int temp1 = 0;
            int temp2 = 0;
            // Add all integers till . and repeat that after .
            while (i < version1.length() && version1.charAt(i) != '.') {
                temp1 = temp1 * 10 + version1.charAt(i) - '0';
                i++;
            }
            // Add all integers till . and repeat that after .
            while (j < version2.length() && version2.charAt(j) != '.') {
                temp2 = temp2 * 10 + version2.charAt(j) - '0';
                j++;
            }

            if (temp1 > temp2) {
                return 1;
            } else if (temp1 < temp2) {
                return -1;
            } else {
                i++;
                j++;
            }
        }

        return 0;
    }
}
