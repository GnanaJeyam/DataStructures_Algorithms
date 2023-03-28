package com.jeyam.dsalgo.Trees;

/**
 * This is function problem to find the whether the binary tree is Sum Tree or Not.
 * https://practice.geeksforgeeks.org/problems/sum-tree/1
 */
class SumTree
{
	boolean isSumTree(Node root)
	{
        if(root == null) return true;
        
        int left = findSum(root.left);
        int right = findSum(root.right);
        
        return root.data == (left + right);
	}
	
	int findSum(Node r) {
	    
	    if(r == null) return 0;
	    
	    return r.data + findSum(r.left) + findSum(r.right);
	}
}