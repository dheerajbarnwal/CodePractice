/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int postEnd;
    TreeNode helper(int inStart,int inEnd,int[] in, int[] post){
        if(inStart>inEnd){
            return null;
        }
        TreeNode root = new TreeNode(post[postEnd--]);
        if(inStart==inEnd){ // If this node has no children then return
            return root;
        }
        int inIndex=0;
        for(int i=inStart;i<=inEnd;i++){
            if(in[i]==root.val){
                inIndex=i;
                break;
            }
        }
        //As postOrder is given, so first buld right subtree and the left subtree
        root.right = helper(inIndex+1,inEnd,in,post);
        root.left= helper(inStart,inIndex-1,in,post);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = inorder.length;
        postEnd=len-1;
        return helper(0,len-1,inorder,postorder);
    }
}