package com.jeyam.dsalgo.Trees;

/**
 * This is the function problem to find the whether the binary tree is a Mirror image of itself or not.
 * https://practice.geeksforgeeks.org/problems/symmetric-tree/1
 */
class SymmetricTree
{
    // return true/false denoting whether the tree is Symmetric or not
    public static boolean isSymmetric(Node root)
    {
        if(root == null) return true;
        
        return symmetric(root.left, root.right);
    }
    
    static boolean symmetric(Node l, Node r){
        
        if(l == null && r == null) return true;
        
        if(l == null || r == null) return false;
        
        if(l.data != r.data) return false;
        
        return symmetric(l.left, r.right) && symmetric(l.right, r.left);
        
    }
    
}