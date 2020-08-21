/**
 * This is function problem to find the Extreme nodes in alternate order in binary tree.
 * https://practice.geeksforgeeks.org/problems/extreme-nodes-in-alternate-order/1
 */

class ExtremeNodesInAlternateOrder {
    public  ArrayList<Integer> ExtremeNode(Node node)
      {
         if(node == null) return null;
         
         ArrayList<Integer> arrays = new ArrayList<>();
         
         Queue<Node> queue = new LinkedList<>();
         queue.add(node);
         
         int val = 0;
         int last = 0;
         boolean flag = true;
         while ( !queue.isEmpty()) {
            int s = queue.size();
            int i = 0;
            
            while(i < s) {
              Node t = queue.poll();

              if(s-1 == i && flag) {
                  arrays.add(t.data);
              }else if(i == 0 && !flag) {
                  arrays.add(t.data);
              }
              i++;   
              if(t.left != null) queue.add(t.left);
              if(t.right != null) queue.add(t.right);
            }
            
            flag = !flag;
         }
             
         return arrays;
      }
}