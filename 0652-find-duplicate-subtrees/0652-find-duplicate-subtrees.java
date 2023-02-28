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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> ans = new ArrayList<>();
        Map<String,Integer> freq = new HashMap<>();
        recur(root,ans,freq);
        return ans;
    }
    
    String recur(TreeNode root, List<TreeNode> ans, Map<String,Integer> freq){
        if(root==null){
            return "";
        }
        
        String val = "(" + recur(root.left,ans,freq) + ")" + root.val + "(" + recur(root.right,ans,freq) + ")";
        if(!freq.containsKey(val)){
            freq.put(val,0);
        }
        freq.put(val,freq.get(val)+1);
        if(freq.get(val)==2){
            ans.add(root);
        }
        return val;
    }
    
}