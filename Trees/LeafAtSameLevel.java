/**
 * This is the functional problem to check the leafs in the binary tree are at same level.
 * https://practice.geeksforgeeks.org/problems/leaf-at-same-level/1
 */
class GfG
{
    boolean check(Node root)
    {
        
        if(root == null) return true;
        
        Map<Integer,Integer> map = new HashMap<>();
        addLevels(root, map, 0);
        
        if(map.size() > 1) {
            return false;
        }
        
        return true;
    }
    
    private void addLevels(Node root, Map<Integer,Integer> map, int level) {
        
        if(root == null) return;
        
        if(root.left == null && root.right == null) {
            map.put(level, 1);            
        }
        
        addLevels(root.left, map, level+1);
        addLevels(root.right, map, level+1);
    }
}
