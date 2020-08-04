/**
 * This is functional problem. 
 * Given two Binary Search Trees(without duplicates). Find need to print the common nodes in them. In other words, find intersection of two BSTs
 * https://practice.geeksforgeeks.org/problems/print-common-nodes-in-bst/1
 */
class CommonNodesInBST
{
	// print a list containing the intersection of the two BSTs in a sorted order
	public static ArrayList<Integer> printCommon(Node root1,Node root2)
    {
        Map<Integer,Integer> m = new HashMap<Integer,Integer>();
        
        ArrayList<Integer> arrays  = new ArrayList<>();
        
        search(root1, m);
        search(root2, m);
        
        m.entrySet()
         .stream()
         .filter(e -> e.getValue() == 2) 
         .sorted(Map.Entry.comparingByKey())
         .forEach(e -> arrays.add(e.getKey()));
        
        return arrays;
    }
    
    private static void search(Node root, Map<Integer,Integer> m){
        
        if(root == null) return;
        
        int c = m.getOrDefault(root.data, 0);
        m.put(root.data, c+1);
        
        search(root.left, m);
        search(root.right, m);
    }
}
