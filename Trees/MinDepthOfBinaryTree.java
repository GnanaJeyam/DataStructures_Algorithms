/**
 * This is function problem to find the minimum depth of the binary tree.
 * https://practice.geeksforgeeks.org/problems/minimum-depth-of-a-binary-tree/1
 */
class MinDepthOfBinaryTree
{
	int minDepth(Node root)
	{
	    if(root == null){
            return Integer.MAX_VALUE;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
	    
	    return 1 + Math.min(minDepth(root.left), minDepth(root.right));
	}
}
