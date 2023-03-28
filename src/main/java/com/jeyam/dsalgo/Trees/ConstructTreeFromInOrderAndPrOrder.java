package com.jeyam.dsalgo.Trees; /**
 * This is functional problem to construct the binary tree from inorder and preorder.
 * https://practice.geeksforgeeks.org/problems/construct-tree-1/1
 */
import java.util.*;
class ConstructTreeFromInOrderAndPrOrder
{
    private static Map<Integer,Integer> inOrderBucket;
    private static Integer currIndex;
    
    public static Node buildTree(int inorder[], int preorder[], int n)
    {
        inOrderBucket = new HashMap<>();
        currIndex = 0;
        
        for(int i=0; i<inorder.length; i++){
            inOrderBucket.put(inorder[i], i);
        }
        
        Node tree = construct(inorder, preorder, 0, n-1);
        
        return tree;
    }
    
    private static Node construct(int inorder[], int preorder[], int s, int e) {
        
        if(s > e || currIndex >= preorder.length) return null;
        
        int data = preorder[currIndex++];
        Node newNode = new Node(data);
        
        int i = inOrderBucket.get(data);
        
        newNode.left = construct(inorder, preorder, s, i-1);
        newNode.right = construct(inorder, preorder, i+1, e);        
        
        return newNode;
    }
}
