package org.dsa.linkedlist;
class Node{
    int data;
    Node next;
    Node prev;

    public Node(int data){
        this.data = data;
    }
}

public class DLL {
    private Node head;
    private Node tail;

    public DLL(int data){
        this.head = new Node(data);
    }
}

