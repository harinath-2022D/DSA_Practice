package org.dsa.linkedlist;

public class Main {
     public static void main(String[] args) {
        LinkedLists li = new LinkedLists(1);
        li.addNode(2);
        li.addNode(3);
        li.remove(6);
        li.printList();
    }
}
