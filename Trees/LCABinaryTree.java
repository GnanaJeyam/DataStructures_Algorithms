/**
 * This is the function problem to return the lowest common ancestor between two nodes/numbers.
 * https://practice.geeksforgeeks.org/problems/lowest-common-ancestor-in-a-bst/1
 */
class LCABinaryTree
{   
    // Returns the LCA of the nodes with values n1 and n2
    // in the BST rooted at 'root' 
	Node LCA(Node root, int n1, int n2)
	{
	    if(root == null) return root;
	    
	    if(root.data == n1 || root.data == n2){
	        return root;
	    }
        
        Node left = LCA(root.left, n1, n2);
        Node right = LCA(root.right, n1, n2);
        
        if(left != null && right != null) {
            return root;
        }
        
        return left != null ? left : right;
    }
    
}