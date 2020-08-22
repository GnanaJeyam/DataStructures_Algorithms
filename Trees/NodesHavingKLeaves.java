/**
 * This is Functional problem to print the nodes with k leaves.
 * Medium problem.
 * https://practice.geeksforgeeks.org/problems/print-nodes-having-k-leaves/1
 */
class NodesHavingKLeaves
{
    public ArrayList<Integer> btWithKleaves(Node root, int k)
    {
        ArrayList<Integer> result = new ArrayList<>();
        findLeaves(root, k, result);
        
        if(result.isEmpty()) {
            result.add(-1);
        }
        
        return result;
    }
    
    private int findLeaves(Node root, int k, ArrayList<Integer> result) {
        
        if(root == null) return  0;
        
        if(root.left == null && root.right == null) return 1;
        
        int left = findLeaves(root.left, k, result);
        int right = findLeaves(root.right, k, result);
        
        if(left + right == k){
            result.add(root.data);
        }
        
        return left + right;
    } 
    
}