package com.jeyam.dsalgo.Trees; /**
 * This the function problem to construct the binary search tree from binary tree.
 * https://practice.geeksforgeeks.org/problems/binary-tree-to-bst/1
 */
import java.util.*;
class BinaryTreeToBst
{
    // The given root is the root of the Binary Tree
    // Return the root of the generated BST
    Node binaryTreeToBST(Node root)
    {
       List<Integer> arrays = new ArrayList<>();
       addValues(root, arrays);
       Node bst = null;
       for(int i=0; i<arrays.size(); i++) {
           bst = constructBst(bst, arrays.get(i));
       }
       return bst;
    }
    
    private Node constructBst(Node root, int data) {
        if(root == null){
            return new Node(data);
        }
        
        if(root.data > data){
            root.left = constructBst(root.left, data);
        }else{
            root.right = constructBst(root.right, data);
        }
        
        return root;
    }
    
    private void addValues(Node root, List<Integer> arrays) {
        
        if(root == null) return;
        
        arrays.add(root.data);
        
        addValues(root.left, arrays);
        addValues(root.right, arrays);
    }
}
 