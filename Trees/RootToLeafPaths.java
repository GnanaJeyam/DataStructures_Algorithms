/**
 * This is the functional problem to print the all root to leaf paths in the binary tree.
 * https://practice.geeksforgeeks.org/problems/root-to-leaf-paths/1
 */
class RootToLeafPaths{
    
    public void printPaths(Node root){
        LinkedList<Integer> deque = new LinkedList<Integer>();
        printPaths(root, deque);
    }
    
    private void printPaths(Node root, LinkedList<Integer> deque) {
        
        if(root == null) return;
        
        deque.add(root.data);

        if(root.left == null && root.right == null){
             deque.forEach(e -> {
                System.out.print(e+" ");
             });
             System.out.print("#");
             deque.removeLast();
             return;
        }
        
        printPaths(root.left, deque);
        printPaths(root.right, deque);
        
        deque.removeLast();
    }
    
}