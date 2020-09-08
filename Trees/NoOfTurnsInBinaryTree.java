/**
 * This is functional problem to find the number of turns between 2 nodes in the binary tree.
 * https://practice.geeksforgeeks.org/problems/number-of-turns-in-binary-tree/1
 * Hard Problem
 */
class NoOfTurnsInBinaryTree
{
    
    static int count = 0;
    
    /**
     * This method is used find the Lowest common ancestor
     * between @param first and @param second 
     **/
    static Node lca(Node root, int first, int second) {
        
        if(root == null) return null;
        
        if (root.data == first || second == root.data) {
           return root; 
        }
        
        Node left = lca(root.left, first, second);
        Node right = lca(root.right, first, second);
        
        if(left != null && right != null) return root;
        
        return left != null ? left : right;
    }
    
    /**
     * This method will increase the count of turns 
     * based on the path between root and target node.
     **/
    static boolean countTurns(Node root, int target, boolean turn) {
        
        if(root == null) return false;
        
        if(root.data == target) return true;
        // If it is left turn then we increase count of turns only when
        // we are moving to right turn
        if(turn){
            
            if(countTurns(root.left, target, turn)) {
                return true;
            }
            
            if(countTurns(root.right, target, !turn)) {
                count++;
                return true;
            }
            
        } else {
            // If it right turn then we increase count of turns only when
            // we are moving to left turn
            
            if(countTurns(root.left, target, !turn)) {
                count++;
                return true;
            }
            
            if(countTurns(root.right, target, turn)) {
                return true;
            }
        }
        
        return false;
    }
    
    static int NumberOfTurns(Node root, int first, int second)
    {
        Node lca = lca(root, first, second);
        
        if(lca == null) return -1;
        
        count = 0;
        
        // If the lca is the first node Then from the first node
        // we need to calculate the count turns to second node.
        if(lca.data == first) {
            if (countTurns(lca.left, second, true) ||
                countTurns(lca.right, second, false)) {
             return count;      
            }
        } else if(second == lca.data) {
        // If the lca is the second node Then from the first node
        // we need to calculate the count turns to left node.
            if (countTurns(lca.left, first, true) ||
                countTurns(lca.right, first, false)) {
             return count;     
            }
        } else {
        // If the lca is not the first/second node. 
        // Then we need to go to first node from the lca/root and update the count
        // After that we need to do same for second node from the lca/root
            if (countTurns(lca.left, second, true) ||
                countTurns(lca.right, second, false)) {
                   
            }
            
            if (countTurns(lca.left, first, true) ||
                countTurns(lca.right, first, false)) {
                   
            }
            
            return count + 1;
        }
        
        return 0;
    }
}
