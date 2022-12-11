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
    int ans; 
    public int maxPathSum(TreeNode root) {
        ans = Integer.MIN_VALUE;
        calculate(root);
        return ans;
    }
    
    int calculate(TreeNode root){
        if(root==null)
            return 0;
        int leftVal = Math.max(calculate(root.left),0);
        int rightVal = Math.max(calculate(root.right),0);
        
        ans = Math.max(ans, leftVal+root.val+rightVal);
        return Math.max(leftVal+root.val, rightVal+root.val);
    }
}