package com.jeyam.dsalgo.Trees; /**
 * This is the functional problem to serialize and deserialize the binary tree.
 * https://practice.geeksforgeeks.org/problems/serialize-and-deserialize-a-binary-tree/1
 */
import java.util.*;
class SerializeAndDeserialize {
    int p = 0;
	public void serialize(Node root, ArrayList<Integer> A) {
	    
	    if(root == null) {
	        A.add(-1);
	        return;
	    }
	    
	    A.add(root.data);

	    serialize(root.left, A);
	    
	    serialize(root.right, A);
	    
	}
	
    public Node deSerialize(ArrayList<Integer> A){
        
        if(A.size() <= p || A.get(p) == -1){
            p++;
            return null;
        }
        
        Node root = new Node(A.get(p));
        p++;
        root.left = deSerialize(A);
        root.right = deSerialize(A);
        
        return root;
    }
    
}