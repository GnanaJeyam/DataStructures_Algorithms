package com.jeyam.dsalgo.Trees;

/**
 * This is the functional problem to transform the binary tree to sum tree.
 * https://practice.geeksforgeeks.org/problems/transform-to-sum-tree/1
 */
class TransformToSumTree {
    public void toSumTree(Node root){
         transform(root);
    }
    
    private int transform(Node r){
        
        if(r == null) return 0;
        
        int t = r.data;
        int left = transform(r.left);
        int right = transform(r.right);
        r.data = left + right;
        
        return t + r.data;
    }
}