package com.jeyam.dsalgo.Trees;

/**
 * This is a functional problem to find Height of Spiral Tree.
 * Given a special Binary Tree whose leaf nodes are connected to form a circular doubly linked list. Find the height of this special Binary Tree.
 * https://practice.geeksforgeeks.org/problems/height-of-spiral-tree/1
 */

class HeightOfSpiralTree
{
    // Return the height of the given special binary tree
    public static int findTreeHeight(Node root)
    {
        if(root == null)
            return 0;
        
        if(root.right != null && root.right.left == root) {
            return 1;
        }
        
        return 1 + Math.max( findTreeHeight(root.left), findTreeHeight(root.right) );
    }
}