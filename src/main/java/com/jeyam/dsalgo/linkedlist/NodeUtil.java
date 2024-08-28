package com.jeyam.dsalgo.linkedlist;

public final class NodeUtil {

    public static void printNode(Node<?> node) {
        if (node == null) {
            var nullNodeFound = "Null node found";
            System.out.println(nullNodeFound);
            throw new NullPointerException(nullNodeFound);
        }

        StringBuilder sb = new StringBuilder();

        while (node != null) {
            sb.append(node.getType());
            sb.append(" -> ");

            if (node.getNext() != null && node.getNext().getNext() == null) {
                sb.append(node.getNext().getType());
                break;
            }

            node = node.getNext();
        }

        System.out.println(sb);
    }

    public static void printNodeBottom(Node<?> node) {
        if (node == null) {
            var nullNodeFound = "Null node found";
            System.out.println(nullNodeFound);
            throw new NullPointerException(nullNodeFound);
        }

        StringBuilder sb = new StringBuilder();

        while (node != null) {
            sb.append(node.getType());
            sb.append(" -> ");

            if (node.getBottom() != null && node.getBottom().getBottom() == null) {
                sb.append(node.getBottom().getType());
                break;
            }

            node = node.getBottom();
        }

        System.out.println(sb);
    }

    public static Node<Integer> getSimpleNode() {
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
