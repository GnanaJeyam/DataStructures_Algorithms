/**
 * This is the function problem to find the diameter of the binary tree.
 * https://practice.geeksforgeeks.org/problems/diameter-of-binary-tree/1
 */
class DiameterOfTree {
    /* Complete the function to get diameter of a binary tree */
    int diameter(Node root) {
        
        if (root == null) {
            return 0;
        }
        
        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);
        int total = 1 + leftHeight + rightHeight;
        
        int ldiameter = diameter(root.left);
        int rdiameter = diameter(root.right);
        
        return Math.max(total, Math.max(ldiameter, rdiameter) );
        
    }
    
    private int findHeight(Node root) {
        if (root == null) {
            return 0;
        }
        
        return 1 + Math.max(findHeight(root.left), findHeight(root.right));
    } 
}