/**
 * Created by Dheeraj Kumar Barnwal on 09/04/18.
 * Alternating split of a given Singly Linked List
 */
public class LLAlter {
    static private class Node{
        int data;
        Node next;
        private Node(int d){
            data=d;
            next=null;
        }
    }
    static Node head,a,b;
    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
    void alter(Node head){
        a=head;
        b=head.next;
        Node temp=head;
        while(temp!=null && temp.next!=null){
            Node next = temp.next;
            temp.next=next.next;
            temp=next;
        }
    }
    public static void main(String args[]){
        LLAlter list = new LLAlter();
        list.head = new Node(85);
        list.head.next = new Node(15);
        list.head.next.next = new Node(4);
        list.head.next.next.next = new Node(20);
        list.head.next.next.next.next = new Node(30);
        list.head.next.next.next.next.next = new Node(40);
        list.head.next.next.next.next.next.next = new Node(50);

        System.out.println("Given Linked list");
        list.printList(head);
        list.alter(head);
        //System.out.println("");
        System.out.println("\na ");
        list.printList(a);
        System.out.println("\nb ");
        list.printList(b);
    }
}
