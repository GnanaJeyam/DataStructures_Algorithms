package com.jeyam.dsalgo.linkedlist;

import static com.jeyam.dsalgo.linkedlist.NodeUtil.printNode;

public class MergeTwoSortedList {
    public static void main(String[] args) {
        Node<Integer> first = getListOne();

        Node<Integer> second = getListTwo();

        Node<Integer> head = null;
        Node<Integer> prev = null;

        while (first != null && second != null) {
            int currentData;
            if (first.getType() < second.getType()) {
                currentData = first.getType();
                first = first.getNext();
            } else {
                currentData = second.getType();
                second = second.getNext();
            }
            if (head == null) {
                head = new Node<>(currentData);
                prev = head;
            } else {
                prev.setNext(new Node<>(currentData));
                prev = prev.getNext();
            }
        }

        while (first != null) {
            prev.setNext(new Node<>(first.getType()));
            prev = prev.getNext();
            first = first.getNext();
        }

        while (second != null) {
            prev.setNext(new Node<>(second.getType()));
            prev = prev.getNext();
            second = second.getNext();
        }

        printNode(head);

        // Recursive approach
        printNode(recursiveApproach(getListOne(), getListTwo()));
    }

    private static Node<Integer> recursiveApproach(Node<Integer> l1, Node<Integer> l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.getType() < l2.getType()) {
            l1.setNext(recursiveApproach(l1.getNext(), l2));
            return l1;
        } else {
            l2.setNext(recursiveApproach(l1, l2.getNext()));
            return l2;
        }
    }

    private static Node<Integer> getListTwo() {
        Node<Integer> three = new Node<>(3);
        Node<Integer> seven = new Node<>(7);

        three.setNext(seven);
        seven.setNext(new Node<>(10));

        return three;
    }

    private static Node<Integer> getListOne() {
        Node<Integer> one = new Node<>(1);
        Node<Integer> two = new Node<>(2);
        Node<Integer> five = new Node<>(5);
        Node<Integer> eight = new Node<>(8);
        Node<Integer> ten = new Node<>(10);

        one.setNext(two);
        two.setNext(five);
        five.setNext(eight);
        eight.setNext(ten);
        return one;
    }


}
