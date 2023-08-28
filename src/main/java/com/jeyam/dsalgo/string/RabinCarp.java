package com.jeyam.dsalgo.string;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.codingninjas.com/studio/problems/stringmatch-rabincarp_1115738
 */
public class RabinCarp {
    public static void main(String[] args) {
        String text = "cxyzghxyzvjkxyz";
        String pat = "xyz";

        System.out.println("Result " +  stringMatch(text, pat));
    }

    public static List< Integer > stringMatch(String text, String pattern){
        int i=0;
        List<Integer> res = new ArrayList<>(pattern.length());
        char firstCharacter = pattern.charAt(0);
        while(i < text.length()) {
            if (firstCharacter == text.charAt(i) ) {
                int index = i;
                int x = i+1;
                boolean hasField = true;
                for (int j = 1; j < pattern.length(); j++) {
                    if ((x >= text.length()) || text.charAt(x) != pattern.charAt(j)) {
                        hasField = false;
                        break;
                    }
                    x++;
                }
                if (hasField) {
                    res.add(index + 1);
                }
                i++;

            } else {
                i++;
            }
        }

        return res;
    }
}
