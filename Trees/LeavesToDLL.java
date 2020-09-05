/**
 * This is the functional problem to convert the leaves to DLL.
 * https://practice.geeksforgeeks.org/problems/leaves-to-dll/1
 */
class LeavesToDLL{
    
    Node head = null;
    Node prev = null;
    
    // return the head of the DLL and remove those node from the tree as well.
    public Node convertToDLL(Node root)
    {
        convertToDll(root);
        return head;
    }
    
    private Node convertToDll(Node root){
        
        if(root == null) return null;
        
        if(root.left == null && root.right == null){
            if(prev == null){
                head = root;
            }else{
                prev.right = root;
                root.left = prev;
            }
            prev = root;
            return null;
        }
        
        root.left = convertToDll(root.left);
        root.right = convertToDll(root.right);
        
        return root;
    }
    
}