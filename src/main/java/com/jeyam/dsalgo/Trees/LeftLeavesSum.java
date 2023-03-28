package com.jeyam.dsalgo.Trees; /**
 * This is functional problem to add left leaves sum in binary tree.
 */
import java.util.*;
class LeftLeavesSum {
    private ArrayList<Integer>a=new ArrayList<>();
    public int leftLeavesSum(Node root) 
    { 
       dfs(root);
       int cnt=0;
       for(int i:a)cnt+=i;
       return cnt;
    
    } 
    public void dfs(Node n){
        if(n==null)return ;
        
        if(n.left!=null &&(n.left.left==null&&n.left.right==null))
        a.add(n.left.data);
        
        dfs(n.right);
        dfs(n.left);

    }

}