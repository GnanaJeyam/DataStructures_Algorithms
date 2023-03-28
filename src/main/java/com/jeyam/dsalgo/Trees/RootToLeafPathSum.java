package com.jeyam.dsalgo.Trees; /**
 * This is function problem to find the Root to leaf path sum in a binary tree.
 * https://practice.geeksforgeeks.org/problems/root-to-leaf-path-sum/1
 */
import java.util.*;
class RootToLeafPathSum {
    /*you are required to complete this function */
    boolean hasPathSum(Node node, int sum) {
        if(node == null) return false;
        return validate(node, sum, 0);
    }
    
    private boolean validate(Node root, int sum, int t) {
        if (root == null) return false;
        
        if (t +root.data == sum && root.left == null && root.right == null) {
            return true;   
        }
        return validate(root.left, sum, t+root.data) || validate(root.right, sum, t+root.data);
    }
    
}