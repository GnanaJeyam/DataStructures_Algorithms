package com.jeyam.dsalgo.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class RandomPointer {
    public static void main(String[] args) {
        copyRandomListUsingExtraSpace(null);
        copyRandomListUsingOptimal(null);
    }

    private static Node<Integer> copyRandomListUsingOptimal(Node<Integer> head) {
        if (head == null) {
            return null;
        }

        Node<Integer> start = head;

        // TO create link for next pointer
        // Create the duplicate node and link it between the current and next pointer

        while(start != null) {
            Node<Integer> current = start.getNext();
            Node<Integer> copy = new Node<>(start.getType());
            start.setNext(copy);
            copy.setNext(current);
            start = current;
        }

        start = head;

        // TO create link for random/bottom pointer
        // duplicate.random = head.random.next
        // Because current list in this format | N1 -> D1 -> N2 -> D2
        // So this expression will work duplicate.random = head.random.next

        while (start != null) {
            Node<Integer> nextC = start.getNext();
            Node<Integer> current = start.getNext();
            if (current != null) {
                current = start.getNext().getNext();
            }

            if (start.getBottom() != null) {
                nextC.setBottom(start.getBottom().getNext());
            }

            start = current;
        }

        start = head;

        Node<Integer> dummy = start.getNext();

        // Finally break the duplicate link between the original nodes and relink them to actual state

        while (start != null) {
            Node<Integer> nc = start.getNext();
            if (nc != null) {
                start.setNext(nc.getNext());
                if (start.getNext() != null) {
                    nc.setNext(start.getNext().getNext());
                }
            }
            start = start.getNext();
        }

        return dummy;
    }

    public static Node<Integer> copyRandomListUsingExtraSpace(Node<Integer> head) {

        Map<Node<Integer>,Node<Integer>> bucket = new HashMap<>();

        /**
         * Algorithm:
         * 1. Iterate the list and store each node, and it's copy as key,value pair in hashmap.
         * 2. Iterate the list and do lookup for each node in hashmap. Once you got the node,
         * 3. we need to do following tasks:
         * 4. We need to copy next and random(bottom) pointer by doing the same lookup and overriding its state.
         *
         * TC: O(N) + O(N)
         * SC: O(N)
         */

        Node<Integer> start = head;

        while(start != null) {
            bucket.put(start, new Node<>(start.getType()));
            start = start.getNext();
        }

        start = head;
        Node<Integer> prev = null;
        Object[] s = new String[1];
        while(start != null) {
            Node<Integer> t = bucket.get(start);
            if (prev == null) {
                prev = t;
            }

            t.setNext(bucket.get(start.getNext()));
            t.setBottom(bucket.get(start.getBottom()));

            start = start.getNext();
        }

        return prev;
    }
}
