package com.jeyam.dsalgo.Trees;

/**
 * Evalutate the expression tree and return the final result.
 * the tree will look like
      -
    /   \
  4     7
 On simplification gives  4 - 7 =  -3
 */
class ExpressionTree {
    static class Node {
        String data;
        Node left;
        Node right;

        Node(String data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public int evalTree(Node root) {
        
        if(root == null) return 0;
        
        int left = evalTree(root.left);
        int right = evalTree(root.right);
        
        String t = root.data;
        int r = 0;
        boolean f = false;
        switch(t){
            case "*":
                r = left * right;
                f = true;
                break;
            case "-":
                r = left - right;
                f = true;
                break;    
            case "+":
                r = left + right;
                f = true;
                break;    
            case "/":
                r = left / right;
                f = true;
                break;
            default:
                break;
        }
        
        if(f) return r;
        return Integer.valueOf(t);
    }
}