package com.jeyam.dsalgo.Leetcode;

/**
 * This is the Leetcode problem to sort array by parity
 * https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/551/week-3-august-15th-august-21st/3431
 */
class SortArrayByParity {
    public int[] sortArrayByParity(int[] a) {
        int s = 0, e = a.length - 1;
        
        while(s < e) {
            if(a[s] % 2 != 0 && a[e] %2 == 0){
                int t = a[s];
                a[s++] = a[e];
                a[e--] = t;
            }else if(a[s] % 2 == 0) {
                s++;
            }else {
                e--;
            }
        }
        
        return a;
    }
}