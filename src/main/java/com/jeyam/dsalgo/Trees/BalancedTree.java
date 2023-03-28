package com.jeyam.dsalgo.Trees;

/**
 * This is functional problem to check whether the tree is balanced or not.
 * The tree is balanced if its left-subtree
 */
class BalancedTree
{
    private boolean flag = true;
     /* This function should return tree if passed  tree 
     is balanced, else false. */
    boolean isBalanced(Node root)
    {
        if(root == null) return true;
        
        getMaxHeight(root);
        return flag;
    }
    
    private int getMaxHeight(Node root) {
        if(root == null) return 0;
        int a = getMaxHeight(root.left);
        int b = getMaxHeight(root.right);
        if(Math.abs(a - b) > 1) {
            flag = false;
        }
        return 1 + Math.max(a, b);
    }
}