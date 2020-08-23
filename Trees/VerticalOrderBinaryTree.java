/**
 * This is the functional problem to display the vertical order in binary tree.
 * https://practice.geeksforgeeks.org/problems/print-a-binary-tree-in-vertical-order/1
 */
class VerticalOrderBinaryTree
{
    static ArrayList <Integer> verticalOrder(Node root)
    {
        Map<Integer,List<Integer>> link = new TreeMap();
        findVertical(root, link, 0);
        ArrayList<Integer> result = new ArrayList<>();
        link.values().stream().forEach(e -> result.addAll(e));
        
        return result;
    }
    
    static void findVertical(Node root, Map<Integer,List<Integer>> link, int level) {
        
        if(root == null) return;
        
        List<Integer> bucket = link.getOrDefault(level, new LinkedList<Integer>());
        bucket.add(root.data);
        link.put(level, bucket);  
        
        findVertical(root.left, link, level-1);
        findVertical(root.right, link, level+1);
        
    }
    
}