package com.jeyam.dsalgo.Trees; /**
 * This is a function problem.
 * Given the binary Tree of and two-node values. Check whether the two-node values are cousins of each other or not.
 */
import java.util.*;
class FindCousinNodesInBtree {
    
    // Returns true if the nodes with values 'a' and 'b' are cousins. Else returns false
    public boolean isCousins(Node root, int a, int b) {
        if(root == null) return true;
        
        int firstparentNode = -1;
        int secondparentNode = -1;
        int fL = 0;
        int sL = 0;
        int level = 1;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()) {
           
           int size = queue.size();
           level++;

           for(int i=0; i<size; i++){
               Node t = queue.poll();
               if(t.left != null){
                   if(t.left.data == a) {
                       firstparentNode = t.data;
                       fL = level;
                   }else if(t.left.data == b) {
                       secondparentNode = t.data;
                       sL = level;
                   }
                  queue.add(t.left);
               }
               
               if(t.right != null) {
                   if(t.right.data == a) {
                       firstparentNode = t.data;
                       fL = level;
                   }else if(t.right.data == b) {
                       secondparentNode = t.data;
                       sL = level;
                   }
                   queue.add(t.right);
               }
           }
           if(fL == sL && firstparentNode != secondparentNode) return true;
        }
        return fL == sL && firstparentNode != secondparentNode;
    }

}