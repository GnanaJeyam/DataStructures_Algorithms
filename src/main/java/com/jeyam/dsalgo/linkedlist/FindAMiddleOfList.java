package com.jeyam.dsalgo.linkedlist;

import static com.jeyam.dsalgo.linkedlist.NodeUtil.getSimpleNode;
import static com.jeyam.dsalgo.linkedlist.NodeUtil.printNode;

/**
 * https://leetcode.com/problems/middle-of-the-linked-list/
 */
public class FindAMiddleOfList {
    public static void main(String[] args) {
        Node<Integer> simpleNode = getSimpleNode();

        Node<Integer> slow = simpleNode;
        Node<Integer> fast = simpleNode.getNext();

        while (fast != null) {
            slow = slow.getNext();
            fast = fast.getNext();
            if (fast != null) {
                fast = fast.getNext();
            }
        }

        printNode(slow);
    }
}
