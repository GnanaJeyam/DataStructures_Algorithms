/**
 * This is a function problem. Given a word, you need to judge whether the usage of capitals in it is right or not.
 * Ex-1:
 * Input: "USA"
 * Output: True
 * Ex-2:
 * Input: "FlaG"
 * Output: False
 * https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/549/week-1-august-1st-august-7th/3409/
 */
class Solution {
    public boolean detectCapitalUse(String word) {
        return word.matches("[A-Z]*|[A-Z]?[a-z]*");
    }
}