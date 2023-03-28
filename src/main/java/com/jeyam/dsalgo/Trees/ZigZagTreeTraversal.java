package com.jeyam.dsalgo.Trees;// Print the zig zag traversal of tree.
import java.util.*;
class ZigZagTreeTraversal
{
    // return an array containing the zig zag level order traversal of the given tree
	ArrayList<Integer> zigZagTraversal(Node root)
	{
	    
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		boolean flag = true;
		ArrayList<Integer> ap = new ArrayList<>();

		while(!queue.isEmpty()) {
			List<Integer> res = new ArrayList<>();
			int c = queue.size();
			for(int i=0; i<c; i++) {
				Node t = queue.poll();
				if(t.left != null) {
					queue.add(t.left);
				}
				if(t.right != null) {
					queue.add(t.right);
				}
				res.add(t.data);
			}
			
			printInt(res, flag,ap);
			flag = !flag;
		}
		
		return ap;
	
	}
	
	static void printInt(List<Integer> ls , boolean flag,ArrayList<Integer> ap) {
		if(flag) {
			for(int i=0; i<ls.size(); i++) {
				ap.add(ls.get(i));
			}
		}else {
			for(int i=ls.size()-1; i>=0; i--) {
				ap.add(ls.get(i));
			}
		}
	}
}