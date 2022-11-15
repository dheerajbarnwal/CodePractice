/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int countNodes(TreeNode root) {
        int lHeight = leftHeight(root);
        int rHeight = rightHeight(root);
        if(lHeight==rHeight){
            return (1<<lHeight)-1;
        }
        return 1+countNodes(root.left)+countNodes(root.right);
    }
    
    int leftHeight(TreeNode root){
        int height = 0;
        while(root!=null){
            height++;
            root=root.left;
        }
        return height;
    }
    
    int rightHeight(TreeNode root){
        int height = 0;
        while(root!=null){
            height++;
            root=root.right;
        }
        return height;
    }
}