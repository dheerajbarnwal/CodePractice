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
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        if(root==null){
            return ans;
        }
        
        while(root!=null || !stack.isEmpty()){
            //push all left node
            while(root!=null){
                stack.push(root);
                root=root.left;
            }
            
            root = stack.pop();
            ans.add(root.val);
            root=root.right; 
        }
        return ans;
    }
}