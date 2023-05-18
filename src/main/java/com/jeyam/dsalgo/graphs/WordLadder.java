package com.jeyam.dsalgo.graphs;

import java.util.HashSet;
import java.util.LinkedList;

/**
 * * https://practice.geeksforgeeks.org/problems/word-ladder/1
 */
public class WordLadder {

    public static void main(String[] args) {
        String wordList[] = {"des","der","dfr","dgt","dfs"};
        var startWord = "der";
        var targetWord = "dfs";
        var wordSet = new HashSet<String>();
        for (var word : wordList) {
            wordSet.add(word);
        }
        var queue = new LinkedList<PairOfAny<String, Integer>>();
        queue.add(new PairOfAny<>(startWord, 1));

        // Remove the startNode as we already added it to the queue and don't want to revisit
        wordSet.remove(startWord);

        int result = 0;
        while(!queue.isEmpty()) {
            var pop = queue.pop();
            var wrd = pop.getA();
            var count = pop.getB();

            // Eventually if we match the target word return
            if (wrd.equals(targetWord)) {
                result = count;
                break;
            }

            for (int i = 0; i < wrd.length(); i++) {
                // Find all combinations from a-z for current index i
                for (char c ='a'; c <= 'z'; c++) {
                    var wordChars = wrd.toCharArray();
                    wordChars[i] = c;
                    var replacedWord = new String(wordChars);

                    if (wordSet.contains(replacedWord)) {
                        queue.add(new PairOfAny<>(replacedWord, count + 1));
                        // Remove the word from the set once you processed or added to the queue
                        wordSet.remove(replacedWord);
                    }
                }
            }

        }

        System.out.print("Final result: " + result);

    }
}
