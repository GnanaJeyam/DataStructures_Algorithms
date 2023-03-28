package com.jeyam.dsalgo.Trees; /**
 * This is the function problem to find the maximum width of the binary tree.
 * https://practice.geeksforgeeks.org/problems/maximum-width-of-tree/1
 */
import java.util.*;
class MaxWidthBinaryTree
{
    
    int getMaxWidth(Node root)
    {
       Map<Integer,Integer> map = new HashMap<>();
       findWidth(root, map, 0);
       
       int max = 0;
       
       for(Map.Entry<Integer,Integer> m : map.entrySet()) {
           int t = m.getValue();
           if(t > max) max = t;
       }
       
       return max;
    }
    
    private void findWidth(Node root, Map<Integer,Integer> map, int l) {
        
        if(root == null) return;
        
        int c = map.getOrDefault(l, 0);
        map.put(l, c+1);
        
        findWidth(root.left, map, l+1);
        findWidth(root.right, map, l+1);
        
    }
}