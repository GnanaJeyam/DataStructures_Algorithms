package com.jeyam.dsalgo.string;

import java.util.ArrayList;

public class KmpSearch {
    public static void main(String[] args) {
        String text = "abcdabcgabcdeflop";
        String pattern = "abcdg";

        // Create LPS
        // This will create prefix table

        int i=0;
        int lps[] = new int[pattern.length()];
        int j = 1;
        for ( ;j < pattern.length(); j++) {
            // If both I & J are equal then set lps[j] with i+1
            if (pattern.charAt(i) == pattern.charAt(j)) {
               lps[j] = i +1;
               i++;
               j++;
            } else {
                // Check whether i != 0 then set i with lps[i-1]
                // since we are reducing by 1 it should not be 0
                if (i != 0) {
                    i = lps[i-1];
                } else {
                    // If i is zero
                    // set lps[j] = 0 and increment i
                    lps[j] = 0;
                    j++;
                }
            }
        }

        i = 0;
        j = 0;
        int t = 0;

        var result = new ArrayList<Integer>();

        while (i < text.length() && j < pattern.length()) {
            if (pattern.charAt(j) == text.charAt(i)) {
                j++;
                i++;
            } else {
                if (j != 0) {
                    j = lps[j-1];
                } else {
                    i++;
                }
                t = i;
            }

            if (j == pattern.length()) {
                result.add(t);
                j = 0;
                t = 0;
            }
        }

        System.out.println("Presented " + result);

    }
}
