/**
 * This is function problem to print the left view of the binary tree.
 * https://practice.geeksforgeeks.org/problems/left-view-of-binary-tree/1
 */
class LeftViewInBinaryTree
{
    void leftView(Node root)
    {
      if(root == null) return;
      
      Queue<Node> queue = new LinkedList<Node>();
      queue.add(root);
      queue.add(null);
      
      while(!queue.isEmpty()){
          Node t = queue.poll();
          if(t != null){
              System.out.print(t.data+" ");
              if(t.left != null){
                  queue.add(t.left);
              }else if(t.right != null){
                  queue.add(t.right);
              }
              
          }else if(!queue.isEmpty()){
              queue.add(null);
          }
          
      }
    }
}