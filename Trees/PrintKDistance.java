/**
 * This is a function problem to print nodes which is K 
 * distance from node.
 */
class PrintKDistance
{
     void printKdistance(Node root, int k)
     {
         printUtil(root, 0, k);
         
     }
     
     private void printUtil(Node root, int cI, int k){
         
         if(root == null) return;
         
         if(cI == k) {
             System.out.print(root.data+" ");
             return;
         }
         
         printUtil(root.left, cI+1, k);
         printUtil(root.right, cI+1, k);
     }
}
