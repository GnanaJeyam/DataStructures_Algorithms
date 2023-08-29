package com.jeyam.dsalgo.linkedlist;

import static com.jeyam.dsalgo.linkedlist.NodeUtil.printNode;

public class ReverseList {

    public static void main(String[] args) {
        var simpleNode = getSimpleNode();
        printNode(simpleNode);

        var reversed = reverse(simpleNode);
        printNode(reversed);
    }

    private static Node<?> reverse(Node<?> head) {
        Node<?> prev = null;

        while (head != null) {
            Node<?> currentNext = head.getNext();
            head.setNext(prev);
            prev = head;
            head = currentNext;
        }

        return prev;
    }

    private static Node<Integer> getSimpleNode() {
        Node<Integer> one = new Node<>(1);
        Node<Integer> two = new Node<>(2);
        Node<Integer> three = new Node<>(3);
        Node<Integer> four = new Node<>(4);
        Node<Integer> five = new Node<>(5);

        one.setNext(two);
        two.setNext(three);
        three.setNext(four);
        four.setNext(five);

        return one;
    }
}
