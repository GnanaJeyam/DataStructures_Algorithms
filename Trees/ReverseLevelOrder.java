/**
 * This is the function problem to print the reverse level order traversal in a binary tree.
 * https://practice.geeksforgeeks.org/problems/reverse-level-order-traversal/1
 */
class ReverseLevelOrder
{
	public void reversePrint(Node node) 
    {
      if(node == null) return;
    
      Queue<Node> queue = new LinkedList<>();
      queue.add(node);
      Stack<Integer> stack = new Stack<>();
      while(!queue.isEmpty()) {
          int size = queue.size();
          while(size-- > 0) {
              Node t = queue.poll();
              if(t.right != null) {
                  queue.add(t.right);
              }
              if(t.left != null) {
                  queue.add(t.left);
              }
              stack.add(t.data);
          }
      }
      
      while(!stack.isEmpty()) {
          System.out.print(stack.pop()+" ");
      }      
            
    }
}