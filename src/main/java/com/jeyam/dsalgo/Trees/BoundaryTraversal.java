package com.jeyam.dsalgo.Trees;
/**
 * This is a functional problem to print the boundary traversal in binary tree.
 * https://practice.geeksforgeeks.org/problems/boundary-traversal-of-binary-tree/1
 */
import java.util.*;
class BoundaryTraversal
{
	ArrayList <Integer> printBoundary(Node root)
	{
	    ArrayList <Integer> result = new ArrayList<>();
	    result.add(root.data);
	    
	    addLeft(root.left, result);
	    addLeafes(root, result);
	    addRight(root.right, result);
	    
	    return result;
	}
	
	private void addLeft(Node root, ArrayList <Integer> result) {
	    
	    if(root == null) return;
	    
	    if(root.left != null || root.right != null) {
	        result.add(root.data);
	        if(root.left != null) {
	            addLeft(root.left, result);
	        }else if(root.right != null) {
	            addLeft(root.right, result);
	        }
	        
	    }
	    
	}
	
	private void addRight(Node root, ArrayList <Integer> result) {
	    
	    if(root == null) return;
	    
	    if(root.left != null || root.right != null) {
	        if(root.right != null) {
	            addRight(root.right, result);
	        } else if(root.left != null) {
	            addRight(root.left, result);
	        } 
	        result.add(root.data);
	    }
	    
	}
	
	private void addLeafes(Node root, ArrayList<Integer> result) {
	    if(root == null) return;
	    
	    if((root.left == null && root.right == null)) {
	        result.add(root.data);
	    }
        addLeafes(root.left, result);
        addLeafes(root.right, result);
	}
}
