package com.jeyam.dsalgo.string;

import java.util.*;

/**
 * https://www.codingninjas.com/studio/problems/roman-numeral-to-integer_981308
 */
public class RomanToInt {
    public static void main(String[] args) {
        Map<Character, List<Integer>> romans = new HashMap<>();
        romans.put('I', new ArrayList<>(Arrays.asList(1, 1)));
        romans.put('V', new ArrayList<>(Arrays.asList(5, 2)));
        romans.put('X', new ArrayList<>(Arrays.asList(10, 3)));
        romans.put('L', new ArrayList<>(Arrays.asList(50, 4)));
        romans.put('C', new ArrayList<>(Arrays.asList(100, 5)));
        romans.put('D', new ArrayList<>(Arrays.asList(500, 6)));
        romans.put('M', new ArrayList<>(Arrays.asList(1000, 7)));

        String s = "LXXIX";

        int n = s.length();
        char[] charArray = s.toCharArray();
        int prevOrder = romans.get(charArray[n-1]).get(1);
        int result = romans.get(charArray[n-1]).get(0);

        for (int i =  n - 2; i>=0; i--) {
            char c = charArray[i];
            List<Integer> values = romans.get(c);
            if (prevOrder > values.get(1)) {
                result = result - values.get(0);
            } else {
                result += values.get(0);
            }
            prevOrder = values.get(1);
        }

        System.out.println("Result " + result);
    }
}
