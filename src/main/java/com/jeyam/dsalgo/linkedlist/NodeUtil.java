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
}
