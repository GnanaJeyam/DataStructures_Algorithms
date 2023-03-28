package com.jeyam.dsalgo.Trees; /**
 * This is a functional problem to Print BST elements in given range.
 * https://practice.geeksforgeeks.org/problems/print-bst-elements-in-given-range/1
 */
import java.util.*;
class BSTInRange
{   
	public static ArrayList<Integer> printNearNodes(Node r, int low, int high)
	{
	    ArrayList<Integer> array = new ArrayList<>();
	    
	    return findNearNodes(r, low, high, array);
    }
    
    private static ArrayList<Integer> findNearNodes(Node r, int low, int high, ArrayList<Integer> array) {
        
	    if(r == null) return array;
	    
	    int data = r.data;
	    
	    if (data > low) {
            findNearNodes(r.left, low, high, array);	        
	    }
	    
	    if(data >= low && data <= high){
	        array.add(data);
	    }
	    
	    if (data <= high) {
	        findNearNodes(r.right, low, high, array);
	    }     
	    
	    return array;
    
    }
    
}