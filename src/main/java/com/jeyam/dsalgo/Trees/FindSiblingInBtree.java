package com.jeyam.dsalgo.Trees; /**
 * This is the functional problem to find the siblings in the binary tree.
 * https://practice.geeksforgeeks.org/problems/print-all-nodes-that-dont-have-sibling/1
 */
import java.util.*;
class FindSiblingInBtree
{   
    private ArrayList<Integer> nodes = new ArrayList<>();
	void printSibling(Node node)
	{
	    findSibling(node);
	    
	    if(nodes.isEmpty()){
	        System.out.print(-1);
	        return;
	    }
	    nodes
	      .stream()
          .sorted()
          .forEach(e -> System.out.print(e+" "));
        
	}
	
	private void findSibling(Node node) {
	    
	    if(node == null) {
	        return;
	    }
	    
	    if(node.left != null && node.right == null) {
	        nodes.add(node.left.data);
	    } else if(node.right != null && node.left == null) {
	        nodes.add(node.right.data);
	    }
	    
	    findSibling(node.left);
	    findSibling(node.right);
	    
	}
}