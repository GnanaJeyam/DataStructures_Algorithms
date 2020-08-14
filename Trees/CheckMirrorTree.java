/**
 * This is the function problem to check Two Binary Trees, write a function that returns true if one is mirror of other, else returns false.
 * https://practice.geeksforgeeks.org/problems/two-mirror-trees/1
 */
class CheckMirrorTree {
    boolean areMirror(Node a, Node b) {
        
        if(a == null && b == null) return true;
        
        if(a == null && b!= null || b == null && a != null) return false;
        
        if(a.data != b.data) return false;
        
        return areMirror(a.left, b.right) && areMirror(a.right, b.left);
    }
}