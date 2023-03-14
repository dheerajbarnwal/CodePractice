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
    int sum=0;
    void sumNumbers(String curr,TreeNode root){
        if(root.left==null && root.right==null){
            sum+=Integer.parseInt(curr);
            return;
        }
        if(root.left!=null)
            sumNumbers(curr+String.valueOf(root.left.val),root.left);
        if(root.right!=null)
            sumNumbers(curr+String.valueOf(root.right.val),root.right);
    }
    public int sumNumbers(TreeNode root) {
        //int sum = 0;
        if(root==null)
            return sum;
        sumNumbers(String.valueOf(root.val),root);
        return sum;
    }
}