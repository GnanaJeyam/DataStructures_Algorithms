package com.jeyam.dsalgo.string;

/**
 * https://leetcode.com/problems/compare-version-numbers/description/
 */
public class CompareVersionNumbers {

    public static void main(String[] args) {
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
