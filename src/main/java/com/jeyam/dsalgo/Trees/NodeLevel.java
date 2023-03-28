package com.jeyam.dsalgo.Trees;

/**
 * This is the functional problem to find the level of a node in binary tree.
 * https://practice.geeksforgeeks.org/problems/level-of-a-node-in-binary-tree/1
 */
class NodeLevel
{
    /* Returns level of given data value */
    int getLevel(Node node, int data)  
    { 
        return findLevel(node, data, 1);
    }
    
    int findLevel(Node root, int data, int level) {
        
        if(root == null) return 0;
        
        if(root.data == data) return level;
        
        int left = findLevel(root.left, data, level+1);
        int right = findLevel(root.right, data, level+1);
        
        if(left == 0 && right == 0) return 0;
        
        return left != 0 ? left : right;
        
    }

}