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
    public int amountOfTime(TreeNode root, int start) {
        Map<Integer,Set<Integer>> map = new HashMap<>();
        convert(root,0,map);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        
        Set<Integer> visited = new HashSet<>();
        visited.add(start);
        int min=0;    
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                int current = queue.poll();
            
                for(int num:map.get(current)){
                    if(!visited.contains(num)){
                        visited.add(num);
                        queue.add(num);
                    }
                }
            }
            min++;
        }
        return min-1;
    }
    
    void convert(TreeNode curr, int parent,Map<Integer,Set<Integer>> map){
        if(curr==null){
            return;
        }
        
        if(!map.containsKey(curr.val)){
            map.put(curr.val,new HashSet<>());
        }
        Set<Integer> adjList = map.get(curr.val);
        if(parent!=0){
            adjList.add(parent);
        }
        if(curr.left!=null){
            adjList.add(curr.left.val);
        }
        if(curr.right!=null){
            adjList.add(curr.right.val);
        }
        
        convert(curr.left,curr.val,map);
        convert(curr.right,curr.val,map);
    }
}