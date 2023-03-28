package com.jeyam.dsalgo.Trees;

/**
 * This is a function problem to reverse the alternate levels of binary tree.
 * https://practice.geeksforgeeks.org/problems/reverse-alternate-levels-of-a-perfect-binary-tree/1
 */
class ReverseAlternateLevels
{
	static void reverseAlternate( Node root)  
    {  
       reverse(root.left, root.right, 0);
       
    }
    
    static void reverse(Node left, Node right, int level) {
        
        if(left == null || right == null) return; 
        
        if(level%2 == 0){
            int t = left.data;
            left.data = right.data;
            right.data = t;
        }
        
        reverse(left.left, right.right, level+1);
        reverse(left.right, right.left, level+1);
        
    }
}