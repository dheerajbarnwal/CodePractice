
import java.util.*;

/**
662. Maximum Width of Binary Tree
        I didn't find the explanation very intuitive, so this is my attempt to make things clear.

        First of all, if you have two positive integers a and b where a < b, than there are exactly (b - a + 1) integers between them including a and b. For example if a = 5, b = 10 than there are 10 - 5 + 1 = 6 integers.

        Now imagine full binary tree, where all nodes on given level have left and right children. If you know relative position of a given node from the left (first node has index 0), than you can compute distance between two nodes on the same level using formula above.

        Our input tree might not be full, however, we can imagine it is full by simply assuming null node has null children on the next level.

        Now, first level (root) has only one node. It's relative position/index from the left is 0. Second level in the imaginary full tree will have 2 (0, 1), third 4 (0, 1, 2, 3) and so on, each level will have twice as much nodes as previous one. If we always visit left child first, than we can make sure that our lookup dictionary left stores positions of the first non-null node to the left for given level.

        Lets take a look at any non-null node in our imaginary full tree where its position from the left is x. If we chose to go one level down, we have two options: follow left or follow right. When we go left, each node to the left of our node on current level produces 2 children meaning position of the left child is 2*x. For example if there are 3 nodes on given level, and we are in the 3rd node, its position is 2 (0, 1, 2) than position of the left child on the next level is 2*2=4 (remember, we track null children to the left). Similar, when we go right, each node on current level produces 2 children plus we have one more, left child of the current node. In other words position of the right child in the full binary tree is 2*x + 1.

        At this point, we have all we need. Now we just need to traverse the tree in preorder (current node, left, right), keep track of relative position from the left in the imaginary full binary tree, and store first visited non-null node on the left. At each node, we will have left position (from the lookup dictionary), current position and we can compute the distance.
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class MaximumWidth {
    Map<Integer,Integer> hm = new HashMap<>();
    int res = 0;
    public void width(TreeNode root, int depth,int pos){
        if(root==null){
            return;
        }
        hm.computeIfAbsent(depth,x->pos);
        res = Math.max(res,pos-hm.get(depth)+1);
        width(root.left,depth+1,2*pos);
        width(root.right,depth+1,2*pos+1);

    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        width(root,0,0);
        return res;
    }
}
