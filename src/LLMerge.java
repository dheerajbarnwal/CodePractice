/**
 * Created by Dheeraj Kumar Barnwal on 08/04/18.
 *
 * Merge two sorted linked lists
 */
public class LLMerge {
    static class Node{
        int data;
        Node next;
        public Node(int d){
            data=d;
            next=null;
        }
    }
    static Node head1,head2;
    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
    Node merge(Node head1,Node head2){
        Node temp,head;
        if(head1==null && head2==null){
            return null;
        }
        if(head1==null){
            return head2;
        }
        if(head2==null){
            return head1;
        }
        if(head1.data<=head2.data){
            temp=head1;
            head1=head1.next;
        }else{
            temp=head2;
            head2=head2.next;
        }
        head=temp;
        while(head1!=null && head2!=null){
            if(head1.data<=head2.data){
                temp.next=head1;
                head1=head1.next;
                temp=temp.next;
            }else{
                temp.next=head2;
                head2=head2.next;
                temp=temp.next;
            }
        }
        if(head1!=null){
            temp.next=head1;
        }
        if(head2!=null){
            temp.next=head2;
        }
        return head;
    }
    public static void main(String args[]){
        LLMerge list = new LLMerge();
        list.head1 = new Node(10);
        list.head1.next = new Node(40);
        list.head1.next.next = new Node(50);
        list.head1.next.next.next = new Node(80);
        System.out.println("first list");
        list.printList(head1);
        list.head2 = new Node(5);
        list.head2.next = new Node(9);
        list.head2.next.next = new Node(25);
        list.head2.next.next.next = new Node(60);
        System.out.println("\nsecond list");
        list.printList(head2);
        Node head= list.merge(head1,head2);
        System.out.println("\nfinal list");
        list.printList(head);
    }
}
