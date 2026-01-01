package org.dsa.linkedlist;

public class LinkedLists {
    private Node head;

    public LinkedLists(Object data){
        this.head = new Node(data, null);
    }

    public void addNode(Object data){
        if(head == null){
            head = new Node(data, null);
            
        }else{
            Node temp = head;

            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = new Node(data, null);
        }
    }

    public void printList(){
        if(head == null) System.out.println("List is empty");

        Node temp = head;

        while(temp != null){
            System.out.print(temp.data.toString() + " -> ");
            temp = temp.next;
        }
    }

    public void remove(){
        if(head == null) return;

        if(head.next == null){
            head = null; return;
        }

        Node temp = head;

        while(temp.next.next != null){
            temp = temp.next;
        }

        temp.next = null;
    }
    
    public void remove(int pos) {
        if (head == null || pos < 0)
            return;

        if (pos == 0) {
            head = head.next;
            return;
        }

        Node temp = head;

        for (int i = 0; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp != null && temp.next != null) {
            temp.next = temp.next.next;
        }
    }

}
