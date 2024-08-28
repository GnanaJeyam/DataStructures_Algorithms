package com.jeyam.dsalgo.linkedlist;

import static com.jeyam.dsalgo.linkedlist.NodeUtil.getSimpleNode;
import static com.jeyam.dsalgo.linkedlist.NodeUtil.printNode;

public class ReverseList {

    public static void main(String[] args) {
        var simpleNode = getSimpleNode();
        printNode(simpleNode);

        var reversed = reverse(simpleNode);
        printNode(reversed);
    }

    private static Node<?> reverse(Node<Integer> head) {
        Node<Integer> prev = null;

        while (head != null) {
            Node<Integer> currentNext = head.getNext();
            head.setNext(prev);
            prev = head;
            head = currentNext;
        }

        return prev;
    }
}
