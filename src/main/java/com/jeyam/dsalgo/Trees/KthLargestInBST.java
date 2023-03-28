package com.jeyam.dsalgo.Trees;

/**
 * This is the function problem to find the Kth largest element in BST.
 * https://practice.geeksforgeeks.org/problems/kth-largest-element-in-bst/1
 */
class KthLargestInBST
{
    static class BST {
        int count;
        int data;
    }
    
    public int kthLargest(Node root,int K)
    {
       BST data = new BST();
       inorder(root, K, data);
        
       return data.data;
    }
    
    private void inorder(Node root, int k, BST data) {
        if(root == null) return;
        inorder(root.right, k, data);
        data.count ++;
        if(data.count == k){
            data.data = root.data;
        }
        inorder(root.left, k, data);
    }
    
}