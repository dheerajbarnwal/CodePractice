/**
 * Created by Dheeraj Kumar Barnwal on 12/04/18.
 * Decimal Equivalent of Binary Linked List
 */
public class LLBinary {
    static private class Node{
        int data;
        Node next;
        private Node(int d){
            data=d;
            next=null;
        }
    }
    static Node head,hcopy;
    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
    void push(int data){
        Node temp = new Node(data);
        if(hcopy==null){
            hcopy = temp;
            head=hcopy;
        }else{
            hcopy.next=temp;
            hcopy=hcopy.next;
        }
    }
    int cal(){
        int res=0;
        while(head!=null){
            res=(res<<1) + head.data;
            head=head.next;
        }
        return res;
    }
    public static void main(String args[]){
        LLBinary list = new LLBinary();
        hcopy=null;
        list.push(0);
        list.push(0);
        list.push(0);
        list.push(1);
        list.push(1);
        list.push(0);
        list.push(0);
        list.push(1);
        list.push(0);
        System.out.println("Given Linked list");
        list.printList(head);
        System.out.println("\nans= "+ list.cal());
    }
}
