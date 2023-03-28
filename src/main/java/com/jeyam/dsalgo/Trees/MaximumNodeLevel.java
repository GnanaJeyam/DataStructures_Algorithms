package com.jeyam.dsalgo.Trees; /**
 * Given a Binary tree. Find the level in binary tree which has the maximum number of nodes.
 */
import java.util.*;
class MaximumNodeLevel
{
    // Return the level (0-indexed) with maximum number of nodes.
    public static int maxNodeLevel(Node root)
    {
        if(root == null) 
            return 0;
            
        Queue<Node> queue = new LinkedList<>();
        
        queue.add(root);
        int maxLevel = 0;
        int maxCount = -1;
        int level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            
            for(int i=0; i<size; i++) {
                Node temp = queue.poll();
                
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
            
            if(size > maxCount){
                maxCount = size;
                maxLevel = level;
            }
            level++;
        }    
        
        return maxLevel;
    }
}