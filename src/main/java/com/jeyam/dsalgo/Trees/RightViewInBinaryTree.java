package com.jeyam.dsalgo.Trees; /**
 * This is function problem to print the right view of the binary tree.
 * https://practice.geeksforgeeks.org/problems/right-view-of-binary-tree/1
 */
import java.util.*;
class RightViewInBinaryTree {
    void rightView(Node root) {
      if(root == null) return;
      
      Queue<Node> queue = new LinkedList<Node>();
      queue.add(root);
      
      while(!queue.isEmpty()){
          int size = queue.size();
          
          while(size-- > 0) {
              Node t = queue.poll();
              if (size == 0) { // Points the last element.
                System.out.print(t.data+" ");    
              }
              if(t.left != null){
                  queue.add(t.left);
              }
              if(t.right != null){
                  queue.add(t.right);
              }
          }
      }
      
    }
}
