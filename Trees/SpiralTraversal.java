/**
 * This is the functional problem to print the binary tree in the spiral order.
 * https://practice.geeksforgeeks.org/problems/level-order-traversal-in-spiral-form/1
 */
class SpiralTraversal
{
      void printSpiral(Node root) 
      {
        if(root == null) return;
      
          Queue<Node> queue = new LinkedList<Node>();
          queue.add(root);
          boolean flag = false;
          while(!queue.isEmpty()){
              int size = queue.size();
              List<Integer> list = new ArrayList<>();
              
              while(size-- > 0) {
                  Node t = queue.poll();
                  list.add(t.data);
                  if(t.left != null){
                      queue.add(t.left);
                  }
                  if(t.right != null){
                      queue.add(t.right);
                  }
              }
              
              if(flag){
                  list.forEach(e -> {
                    System.out.print(e+" ");   
                  });
              }else {
                  Collections.reverse(list);
                  list.forEach(e -> {
                    System.out.print(e+" ");   
                  });
              }
              flag = !flag;
          }
          
      }
}