package com.jeyam.dsalgo.Trees; /**
 * This is the functional problem to print the ancestors of the given key in the binary tree.
 * https://practice.geeksforgeeks.org/problems/ancestors-in-binary-tree/1
 */
import java.util.*;
class PrintAncestors
{
    
    public static boolean printAncestors(Node node, int x)
    {
        printAncestors(node, new LinkedList<Integer>(), x);
        
        return true;
    }
    
    private static void printAncestors(Node root, LinkedList<Integer> list, int x){
        
        if(root == null) return;
        
        if(x == root.data) {
            int size = list.size();
            while(size-- > 0) {
                System.out.print(list.get(size)+" ");
            }
            return;
        }
        
        list.add(root.data);
        
        printAncestors(root.left, list, x);
        printAncestors(root.right, list, x);
        
        list.removeLast();
        
    }
    
}