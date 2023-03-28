package com.jeyam.dsalgo.Leetcode;

/***
 * Lettcode - Distribute Candies to People
 * https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/551/week-3-august-15th-august-21st/3427
 */
class Solution {
    public int[] distributeCandies(int candies, int num_people) {
      
        int count = 1;
        int [] peoples = new int[num_people];
        int candiesSoFar = 0;
        int i = 0;
        while(true){
            if(i >= num_people){
                i = 0;
            }
            peoples[i++] += count;
            candiesSoFar += count;
            
            if(candiesSoFar == candies) break;
            
            if(candiesSoFar + count + 1 > candies){
                count = candies - candiesSoFar;
            }else{
                count += 1;
            }
        }
        
        return peoples;
    }
}