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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        StringBuilder sb1 = new StringBuilder();
        getSequence(root1, sb1);
        
        StringBuilder sb2 = new StringBuilder();
        getSequence(root2, sb2);
        
        return sb1.toString().equals(sb2.toString());
        
    }
    
    void getSequence(TreeNode root, StringBuilder sb){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            sb.append(root.val).append("#");
        }
        getSequence(root.left, sb);
        getSequence(root.right, sb);
    }
}