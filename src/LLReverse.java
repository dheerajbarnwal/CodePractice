/**
 * Created by Dheeraj Kumar Barnwal on 08/04/18.
 */
public class LLReverse {
    static private class Node{
        int data;
        Node next;
        private Node(int d){
            data=d;
            next=null;
        }
    }
    static Node head;
    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
    public void reverse(Node curr,Node prev){
        if(curr.next==null){
            curr.next=prev;
            head=curr;
            return;
        }
        Node next1=curr.next;
        curr.next=prev;
        reverse(next1,curr);
    }
    public static void main(String args[]){
        LLReverse list = new LLReverse();
        list.head = new Node(85);
        list.head.next = new Node(15);
        list.head.next.next = new Node(4);
        list.head.next.next.next = new Node(20);

        System.out.println("Given Linked list");
        list.printList(head);
        list.reverse(head,null);
        System.out.println("");
        System.out.println("Reversed linked list ");
        list.printList(head);
    }
}
