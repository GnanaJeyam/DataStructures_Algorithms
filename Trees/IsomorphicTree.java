/**
 * This is a functional problem to check if Tree is Isomorphic.
 * https://practice.geeksforgeeks.org/problems/check-if-tree-is-isomorphic/1
 */

class IsomorphicTree  
{ 
    // Return True if the given trees are isomotphic. Else return False.
    boolean isIsomorphic(Node r1, Node r2)  
    { 
        if(r1 == null && r2 == null) {
            return true;
        }
        
        if(r1 == null || r2 == null) {
            return false;
        }
        
        if(r1.data != r2.data) return false;
        
        return (isIsomorphic(r1.left,r2.left)  && 
                isIsomorphic(r1.right, r2.right)) ||
               (isIsomorphic(r1.left,r2.right) && 
                isIsomorphic(r1.right, r2.left));
    }
    
}     