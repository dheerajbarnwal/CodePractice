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
    boolean helper(TreeNode left,TreeNode right){
        if(left==null && right==null)
            return true;
        if(left==null || right==null){
            return false;
        }
        if(left.val!=right.val)
            return false;
        return (helper(left.left,right.right) && helper(left.right,right.left));
    }
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;
        return helper(root.left,root.right);
    }
}