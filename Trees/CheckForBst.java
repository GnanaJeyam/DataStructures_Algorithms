/**
 * This is a functional problem to check the binary tree is valid BST or not.
 * https://practice.geeksforgeeks.org/problems/check-for-bst/1
 */
public class CheckForBst
{
    // return true if the given tree is a BST, else return false
    boolean isBST(Node root)
     {
        return checkBst(root, Integer.MIN_VALUE, Integer.MAX_VALUE);     
     }
     
     boolean checkBst(Node root, Integer min, Integer max) {
         
         if(root == null) return true;
         
         if(root.data <= min || root.data > max ) return false;
         
         return checkBst(root.left, min, root.data) &&
                checkBst(root.right, root.data, max);
     }   
        
}