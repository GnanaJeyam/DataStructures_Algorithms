package com.jeyam.dsalgo.Trees;

/**
 * This is the functional problem to convert the binary tree to Doubly linked list.
 * https://practice.geeksforgeeks.org/problems/binary-tree-to-dll/1
 */
class BinaryTreeToDLL
{
    Node head = null;
    Node prev = null;
    
    Node bToDLL(Node root)
    {
	    dfs(root);

	    return head;	
    }
    
    private void dfs(Node root) {
        
        if( root == null) return;
        
        dfs(root.left);

        if(head == null) {
            head = root;
            prev = root;
        }else{   
            root.left = prev;
            prev.right = root;
            prev = root;
        }

        dfs(root.right);
    }
    
}