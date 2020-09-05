/**
 * This is functional problem to find the K nodes from the target node.
 * HARD !!!
 * https://practice.geeksforgeeks.org/problems/nodes-at-given-distance-in-binary-tree/1
 */
class FindKNodesFromTarget
{
    public static ArrayList<Integer> KDistanceNodes(Node root, int target , int k)
    {
        if(root == null) return null;
        
        ArrayList<Integer> results = new ArrayList<>();
        
        // Storing the parent Nodes in the bucket
        HashMap<Node,Node> parentBucket = new HashMap<>();
        addParents(root, parentBucket);
        
        // Find Target node
        Node targetNode = findTarget(root, target);
        
        HashSet<Node> nodes = new HashSet();
        nodes.add(targetNode);
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(targetNode);
        
        // Doing BFS and adding the nodes at K level
        while(!queue.isEmpty()) {
            int size = queue.size();
            k--;
            while(size-- > 0) {
                Node temp = queue.poll();
                
                if(temp.left != null && !nodes.contains(temp.left)) {
                    nodes.add(temp.left);
                    queue.add(temp.left);
                }
                
                if(temp.right != null && !nodes.contains(temp.right)) {
                    nodes.add(temp.right);
                    queue.add(temp.right);
                }
                
                Node parent = parentBucket.get(temp);
                
                if(null != parent && !nodes.contains(parent)) {
                    nodes.add(parent);
                    queue.add(parent);
                }
            }
            
            if(k == 0) break;
        }
        
        while (!queue.isEmpty()) {
            results.add(queue.poll().data);
        }

        Collections.sort(results);
        
        return results;
    }
    
    /**
     * This method is used to find the target node. 
     */
    private static Node findTarget(Node root, int target) {
        if(root == null) return null;
        
        if (root.data == target) {
            return root;
        }
        
        Node left = findTarget(root.left, target);
        
        if(null != left) {
            return left;
        }
        
        Node right = findTarget(root.right, target);
        
        if(null != right) {
            return right;
        }
        
        return null;
    }
    
    /**
     * This method is used to add the parentNodes of all 
     * independent nodes.
     * Basically we are doing DFS (Exploring each node).
     */
    private static void addParents(Node root, HashMap<Node,Node> parentBucket) {
        
        if(root == null) return;
        
        if(root.left != null) {
            addParents(root.left, parentBucket);
            parentBucket.put(root.left, root);
        }
        
        if(root.right != null) {
            addParents(root.right, parentBucket);
            parentBucket.put(root.right, root);
        }
        
    }
    
    
}