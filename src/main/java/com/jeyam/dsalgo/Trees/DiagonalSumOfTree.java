package com.jeyam.dsalgo.Trees; /**
 * This is functional problem to return the list of diagonal sum in the binary tree.
 * https://practice.geeksforgeeks.org/problems/diagonal-sum-in-binary-tree/1 
 */
import java.util.*;
class DiagonalSumOfTree {
    public static ArrayList <Integer> diagonalSum(Node root) 
    {
        ArrayList<Integer> resultList = new ArrayList<>();
        
        if(root == null) {
            return resultList;
        }
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            int sum = 0;
            while(size-- > 0){
                Node t = queue.poll();
                while(t != null){
                    sum += t.data;
                    if(t.left != null) {
                        queue.add(t.left);
                    }
                    t = t.right;
                }
            }
            resultList.add(sum);
        }
        
        return resultList;
    }
}