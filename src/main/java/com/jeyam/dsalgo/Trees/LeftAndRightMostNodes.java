package com.jeyam.dsalgo.Trees; /**
 * This is the functional problem to find the left and right most nodes in the biary tree,
 * https://practice.geeksforgeeks.org/problems/leftmost-and-rightmost-nodes-of-binary-tree/1
 */
import java.util.*;
class LeftAndRightMostNodes
{
    public static void printCorner(Node node)
    {
        if(node == null) return;
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        
        while(!queue.isEmpty()){
            
            int size = queue.size();
            int i = 0;
            while(i < size) {
                Node t = queue.remove();
                
                if( i == 0 || i == size-1) {
                    System.out.print(t.data+" ");
                }
                
                if(t.left != null) {
                    queue.add(t.left);
                }
                
                if(t.right != null) {
                    queue.add(t.right);
                }
                
                i++;
            }
        }
            
    }
    
}