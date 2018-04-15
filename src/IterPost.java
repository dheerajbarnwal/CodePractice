import java.util.Stack;

/**
 * Created by Dheeraj Kumar Barnwal on 15/04/18.
 * Iterative Postorder Traversal | Set 2 (Using One Stack)
 */
public class IterPost {
    private static class Node
    {
        int data;
        Node left, right;

        Node(int item)
        {
            data = item;
            left = right;
        }
    }
    static Node root;
    public static void iter(Node root){
        Stack<Object> s = new Stack();
        s.push(root);
        while(!s.isEmpty()){
            Object temp = s.pop();

            if(temp instanceof Node){
                Node temp1 = (Node)temp;
                s.push(temp1.data);
                if(temp1.right !=null){
                    s.push(temp1.right);
                }
                if(temp1.left!=null){
                    s.push(temp1.left);
                }
            }else{
                System.out.println(temp);
            }
        }
    }
    public static void main(String args[]){
        IterPost tree = new IterPost();

        // Let us create trees shown in above diagram
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        System.out.println("Post order traversal of binary tree is :");
        iter(root);
    }
}
