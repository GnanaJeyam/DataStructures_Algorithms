package com.jeyam.dsalgo.Trees; /**
 * Given a sorted array. Write a program that creates a Balanced Binary Search Tree using array elements.
 * https://practice.geeksforgeeks.org/problems/array-to-bst/0
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
class ArrayToBst
 {
    static class Tree{
        int data;
        Tree left;
        Tree right;
        
        Tree(int data){
          this.data = data;
        }
    } 
     
	public static void main (String[] args) throws Exception
	 {
	    BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(b.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(b.readLine());
            String[] s = b.readLine().split("\\s");
            int[] a = Arrays.stream(s).mapToInt(Integer::parseInt).toArray();
            Tree tree = constructBST(a, 0, n-1);
            preOrder(tree);

            System.out.println();
        }
	 }
	 
	 private static Tree constructBST(int a[], int low, int high) {
	     if(low > high) return null;
	     
	     int mid = low + (high - low)/2;
	     ArrayToBst.Tree tree = new Tree(a[mid]);
	     tree.left = constructBST(a, low, mid-1);
	     tree.right = constructBST(a, mid+1, high);
	     
	     return tree;
	 }
	 
	 private static void preOrder(Tree tree){
	     
	     if(tree == null) return;
	     
	     System.out.print(tree.data+" ");
	     
	     preOrder(tree.left);
	     preOrder(tree.right);
	     
	 }
}