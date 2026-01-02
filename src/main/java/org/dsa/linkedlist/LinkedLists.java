package org.dsa.linkedlist;
class ListNode {
    Object data;
    ListNode next;

    public ListNode(Object data, ListNode next){
        this.data = data;
        this.next = next;
    }
}

public class LinkedLists {
    private ListNode head;

    public LinkedLists(Object data){
        this.head = new ListNode(data, null);
    }

    public void addNode(Object data){
        if(head == null){
            head = new ListNode(data, null);
            
        }else{
            ListNode temp = head;

            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = new ListNode(data, null);
        }
    }

    public void printList(){
        if(head == null) System.out.println("List is empty");

        ListNode temp = head;

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

        ListNode temp = head;

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

        ListNode temp = head;

        for (int i = 0; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp != null && temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    // https://leetcode.com/problems/delete-node-in-a-linked-list/
    public void deleteNode(Node node) {
        if(node == null) return;

        while(node.next.next != null){
            node.data = node.next.data;
            node = node.next;
        }

        node.data = node.next.data;
        node.next = null;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int totalLen = 0;

        ListNode temp = head;

        while(temp != null){
            totalLen++;
            temp = temp.next;
        }

        if(totalLen == n) return head.next;
        int targetIdx = totalLen - n;

        temp = head;
        int currPos = 1;
        while(currPos < targetIdx){
            temp = temp.next;
            currPos++;
        }

        temp.next = temp.next.next;

        return head;
    }
}
