package com.jeyam.dsalgo.string;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String ts[] = {"QQFV", "QQFVvYVwS", "QQFVzC"};
        int min = Integer.MAX_VALUE;
        for (String w:
             ts) {
            min = Math.min(min, w.length());
        }
        int start = 0;

        while (start < min) {
            char prev = ts[0].charAt(start);
            boolean breakLoop = false;
            for (String t : ts) {
                if (t.charAt(start) != prev ) {
                    breakLoop = true;
                    break;
                }
            }

            if (breakLoop ) {
                break;
            }
            start++;
        }

        if (start == 0) {
            System.out.println("-1");
        } else {
            System.out.println(ts[0].substring(0, start));
        }
    }


}
