package com.jeyam.dsalgo.linkedlist;

public class Node<Type> {
    private final Type type;
    private Node next;

    Node(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public Node getNext(){
        return next;
    }

    public void setNext(Node<?> next) {
        this.next = next;
    }
}
