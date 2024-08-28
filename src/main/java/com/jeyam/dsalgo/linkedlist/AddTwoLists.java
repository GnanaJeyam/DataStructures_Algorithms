package com.jeyam.dsalgo.linkedlist;

public class AddTwoLists {
    public static void main(String[] args) {
        Node<Integer> list1 = new Node<>(2);
        var four = new Node<>(4);
        var three = new Node<>(3);
        list1.setNext(four);
        four.setNext(three);

        Node<Integer> list2 = new Node<>(5);
        var six = new Node<>(6);
        var seven = new Node<>(7);
        var nine = new Node<>(9);
        list2.setNext(six);
        six.setNext(seven);
        seven.setNext(nine);

        addList(list1, list2);
    }

    private static void addList(Node<Integer> l1, Node<Integer> l2) {
        Node<Integer> dummy = new Node<>(0); // creating an dummy list
        Node<Integer> curr = dummy; // intialising an pointer
        int carry = 0; // intialising our carry with 0 intiall
        // while loop will run, until l1 OR l2 not reaches null OR if they both reaches null. But our carry has some value in it.
        // We will add that as well into our list
        while(l1 != null || l2 != null || carry == 1){
            int sum = 0; // intialising our sum
            if(l1 != null){ // adding l1 to our sum & moving l1
                sum += l1.getType();
                l1 = l1.getNext();
            }
            if(l2 != null){ // adding l2 to our sum & moving l2
                sum += l2.getType();
                l2 = l2.getNext();
            }
            sum += carry; // if we have carry then add it into our sum
            carry = sum/10; // if we get carry, then divide it by 10 to get the carry
            Node<Integer> node = new Node<>(sum % 10); // the value we'll get by moduloing it, will become as new node so. add it to our list
            curr.setNext(node); // curr will point to that new node if we get
            curr = curr.getNext(); // update the current every time
        }

        NodeUtil.printNode(dummy.getNext());
    }
}
