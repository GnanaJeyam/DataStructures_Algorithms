package com.jeyam.dsalgo.arrays;

import java.util.HashSet;

/**
 * https://takeuforward.org/data-structure/length-of-longest-substring-without-any-repeating-character/
 */
public class LengthOfLongestSubString {
    public static void main(String[] args) {
        String word = "takeaUforward";
        char[] words = word.toCharArray();

        var set = new HashSet<Character>();

        int count = 0;
        int max = 0;

        for (char c : words) {
            var hasCharacter = set.contains(c);
            if (!hasCharacter) {
                count++;
                set.add(c);
                max = Math.max(max, count);
            } else {
                max = Math.max(max, count);
                count = 1;
                set = new HashSet<>();
                set.add(c);
            }
        }

        System.out.println("Length of the Longest unique sub string => " + (max + 1));
    }
}
