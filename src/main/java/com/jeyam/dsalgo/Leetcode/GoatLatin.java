package com.jeyam.dsalgo.Leetcode;

/**
 * Leetcode - Goat Latin
 * https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/551/week-3-august-15th-august-21st/3429/
 */
class GoatLatin {
    public String toGoatLatin(String s) {
        
       if(s == null || s.isEmpty()) return null;
        
       StringBuffer sb = new StringBuffer();
        
       String[] words = s.split(" ");
       StringBuffer ma = new StringBuffer("a");
       for (String word : words) {
           char c = word.charAt(0);
           if( isVowel( Character.toLowerCase(c) )) {
               sb.append(word).append("ma");
           }else {
               sb.append(word.substring(1, word.length())).append(c+"ma");
           }
           sb.append(ma);
           ma.append("a");
           sb.append(" ");
       } 
       return sb.toString().trim(); 
    }
              
    private boolean isVowel(char c){
        switch(c){
            case 'a': return true;
            case 'e': return true;
            case 'i': return true;
            case 'o': return true;
            case 'u': return true;
            default:  return false;
        }
    }
}