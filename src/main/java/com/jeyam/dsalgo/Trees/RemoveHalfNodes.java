package com.jeyam.dsalgo.Trees;

/**
 * This is functional problem. Given A binary Tree. Your task is to remove all the half nodes (which has only one child).
 */

class RemoveHalfNodes
{
    // Return the root of the modified tree after removing all the half nodes.
    public static Node RemoveHalfNodes(Node root)
    {
        if(root == null) return root;
    
        root.left = RemoveHalfNodes(root.left);
        root.right = RemoveHalfNodes(root.right);
        
        if(root.left == null && root.right != null){
            return root.right;
        }
        
        if(root.left != null && root.right == null){
            return root.left;
        }
        
        
        return root;
    }
}
