package com.jeyam.dsalgo.string;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
         String str = "aeiou";
         String res = "";

        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j <str.length() ; j++) {
                String substring = getSubString(str, i, j);
                if (isPalindrome(substring)) {
                    if (substring.length() > res.length()) {
                        res = substring;
                    } else if((substring.length() == res.length())) {
                        int compareTo = substring.compareTo(res);
                        if (compareTo < 0) {
                            res = substring;
                        }
                    }
                }
            }
        }

        System.out.println(res);
    }

    private static String getSubString(String str, int i, int j) {
        if (i == j) return str.charAt(i) + "";
        StringBuilder sb = new StringBuilder();
        for (int k = i; k <= j; k++) {
            sb.append(str.charAt(k));
        }

        return sb.toString();
    }

    private static boolean isPalindrome(String str) {
        int start = 0;
        int end = str.length()-1;

        while (start <= end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}
