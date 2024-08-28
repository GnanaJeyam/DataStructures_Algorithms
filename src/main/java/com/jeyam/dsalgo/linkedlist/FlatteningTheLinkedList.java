package com.jeyam.dsalgo.linkedlist;

public class FlatteningTheLinkedList {
    public static void main(String[] args) {
        var integerNode = getNode();
        var flatten = flatten(integerNode);

        NodeUtil.printNodeBottom(flatten);
    }

    static Node<Integer> flatten(Node<Integer> root)
    {
        if (root == null || root.getNext() == null)
            return root;

        // recur for list on right
        root.setNext(flatten(root.getNext()));

        // now merge
        root = mergeTwoLists(root, root.getNext());

        // return the root
        // it will be in turn merged with its left
        return root;
    }

    static Node<Integer> mergeTwoLists(Node<Integer> a, Node<Integer> b) {

        Node<Integer> temp = new Node<>(0);
        Node<Integer> res = temp;

        while(a != null && b != null) {
            if(a.getType() < b.getType()) {
                temp.setBottom(a);
                temp = temp.getBottom();
                a = a.getBottom();
            }
            else {
                temp.setBottom(b);
                temp = temp.getBottom();
                b = b.getBottom();
            }
        }

        if(a != null) temp.setBottom(a);
        else temp.setBottom(b);

        return res.getBottom();
    }

    private static Node<Integer> getNode() {
        Node<Integer> five = new Node<>(5);
        var seven = new Node<>(35);
        var eight = new Node<>(40);
        seven.setBottom(eight);
        five.setBottom(seven);

        Node<Integer>  ten = new Node<>(10);
        var twenty = new Node<>(20);
        ten.setBottom(twenty);

        Node<Integer> nineTeen = new Node<>(19);
        var twentyTwo = new Node<>(22);
        var fifty = new Node<>(50);
        twentyTwo.setBottom(fifty);
        nineTeen.setBottom(twentyTwo);

        Node<Integer> twentyEight = new Node<>(28);
        var thirtyFive = new Node<>(35);
        var forty = new Node<>(40);
        thirtyFive.setBottom(forty);
        twentyEight.setBottom(thirtyFive);

        five.setNext(ten);
        ten.setNext(nineTeen);
        nineTeen.setNext(twentyEight);

        return five;
    }
}
