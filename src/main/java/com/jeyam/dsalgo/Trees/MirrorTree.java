package com.jeyam.dsalgo.Trees;

/**
 * This is Function problem to convert the tree to mirror tree.
 */
class MirrorTree {
    void mirror(Node node) {
        if (node == null) {
            return;
        }

        mirror(node.left);
        mirror(node.right);
        Node t = node.left;
        node.left = node.right;
        node.right = t;
    }
}