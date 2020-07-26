/**
 * This Implementation class contains the functional logic to
 * Find the Maximum height of a Binary Tree.
 */
class MaxHeightofTheTree
{
    // return the Height of the given Binary Tree
    int height(Node root)
    {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max( height(root.left), height(root.right) );
    }
}