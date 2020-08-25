/*
 * This is the functional problem to find the minimum distance between two nodes.
 * https://practice.geeksforgeeks.org/problems/min-distance-between-two-given-nodes-of-a-bin
 */   
class MinimumDistanceBetweenNodes {
    
    /* 
       Should return minimum distance between a and b
       in a tree with given root
    */
    public int findDist(Node root, int a, int b) {
        Node lca = LCA(root, a, b);
        
        if(lca == null) return -1;
        
        int dist1 = findDistance(lca, a, 0);
        int dist2 = findDistance(lca, b, 0);
        
        return dist1 + dist2;
    }
    
    private Node LCA(Node root, int a, int b) {
        if(root == null) return null;
        
        if(a == root.data || b == root.data) return root;
        
        Node left = LCA(root.left, a, b);
        Node right = LCA(root.right, a, b);
        
        if(left != null && right != null) return root;
        
        return left != null ? left : right;
    }
    
    private int findDistance(Node root, int a, int dist) {
        
        if(root == null) return 0;
        
        if(root.data == a) return dist;
        
        int left = findDistance(root.left, a, dist + 1);
        int right = findDistance(root.right, a, dist + 1);
        
        return Math.max(left, right);
    }
    
}