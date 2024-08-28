package com.jeyam.dsalgo.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    static Map<Integer, DoublyLinkedList> cache = new HashMap<>();

    private final int capacity;
    private final DoublyLinkedList head = new DoublyLinkedList(0, 0);
    private final DoublyLinkedList tail = new DoublyLinkedList(0, 0);

    LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public static void main(String[] args) {
        System.out.println("Cache Test---");
        var lruCache = new LRUCache(2);
        System.out.println(lruCache.get(2));
        lruCache.put(2, 6);
        System.out.println(lruCache.get(1));
        lruCache.put(1, 5);
        lruCache.put(1, 2);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
    }

    private int get(int key) {
        if (cache.containsKey(key)) {
            var node = cache.get(key);
            removeNode(node);
            addToHead(node);
            cache.put(node.getKey(), node);
            return node.getData();
        }

        return -1;
    }

    private void put(int key, int value) {

        if (cache.size() == capacity && !cache.containsKey(key)) {
            removeLast();
        }

        if (!cache.containsKey(key)) {
            var node = new DoublyLinkedList(key, value);
            cache.put(key, node);
            addToHead(node);
        } else {
            var savedNode = cache.get(key);
            removeNode(savedNode);
            var node = new DoublyLinkedList(key, value);
            cache.put(key, node);
            addToHead(node);
        }
    }


    private void removeNode(DoublyLinkedList node) {
        cache.remove(node.getKey());
        var prev = node.getPrev();
        prev.setNext(node.getNext());
        node.getNext().setPrev(prev);
    }

    private void removeLast() {
        cache.remove(tail.getPrev().getKey());
        var prev = tail.getPrev().getPrev();
        prev.setNext(tail);
        tail.setPrev(prev);
    }

    private void addToHead(DoublyLinkedList node) {
        node.next = head.next;
        node.prev = head;
        node.next.prev = node;
        head.next = node;
    }

    static class DoublyLinkedList {
        private final int data;
        private final int key;

        private DoublyLinkedList next;
        private DoublyLinkedList prev;

        DoublyLinkedList(int key, int data) {
            this.key = key;
            this.data = data;
        }

        public DoublyLinkedList getNext() {
            return next;
        }

        public void setNext(DoublyLinkedList next) {
            this.next = next;
        }

        public DoublyLinkedList getPrev() {
            return prev;
        }

        public void setPrev(DoublyLinkedList prev) {
            this.prev = prev;
        }
        public int getKey() {
            return key;
        }
        public int getData() {
            return data;
        }
    }
}
