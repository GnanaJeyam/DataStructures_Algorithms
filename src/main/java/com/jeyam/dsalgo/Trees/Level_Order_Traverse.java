package com.jeyam.dsalgo.Trees; /**
 * This is a function problem to display the binary tree in Level order traversal Line by Line.
 * But I dfs here...
 * https://practice.geeksforgeeks.org/problems/level-order-traversal-line-by-line/1
 */
import java.util.*;
class Level_Order_Traverse
{
    static void levelOrder(Node node) 
    {
        Map<Integer,List<Integer>> map = new LinkedHashMap<>();
        dfs(node, map, 0);
        
        map.values().stream().forEach(e -> {
          e.stream().forEach(x -> System.out.print(x+" "));
          System.out.print("$ ");
        });
        
    }
    
    private static void dfs(Node root, Map<Integer,List<Integer>> map, int level) {
        
        if(root == null) return;
        
        List<Integer> list = map.getOrDefault(level, new ArrayList<Integer>());
        list.add(root.data);
        
        map.put(level, list);
        
        dfs(root.left, map, level+1);
        dfs(root.right, map, level+1);
        
    }
}