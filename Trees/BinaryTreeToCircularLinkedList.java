/**
 * This is functional problem to construct circular linked list from binary tree.
 * https://practice.geeksforgeeks.org/problems/binary-tree-to-cdll/1
 */
class BinaryTreeToCircularLinkedList
{ 
    private Node prev = null;
    private Node head = null;
    
    Node bTreeToClist(Node root)
    {
        convertToDll(root);
        
        prev.right = head;
        head.left = prev;
        
        return head;
    }
    
    private void convertToDll(Node root){
        
        if(root == null) return;
        
        convertToDll(root.left);
        
        if(prev == null){
           head = root;
        }else{
            prev.right = root;
            root.left = prev;
        }
        prev = root;
        
        convertToDll(root.right);        
    }
}