package com.jeyam.dsalgo.linkedlist;

public class Node<Type> {
    private final Type type;
    private Node<Type> next;
    private Node<Type> bottom;

    Node(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public Node<Type> getNext(){
        return next;
    }

    public void setNext(Node<Type> next) {
        this.next = next;
    }
    public Node<Type> getBottom() {
        return bottom;
    }

    public void setBottom(Node<Type> bottom) {
        this.bottom = bottom;
    }
}
