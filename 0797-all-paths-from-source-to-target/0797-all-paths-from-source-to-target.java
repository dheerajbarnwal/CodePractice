class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        
        dfs(graph,0,n-1,new ArrayList<Integer>());
        return ans;
    }
    
    void dfs(int[][] graph, int source, int target, List<Integer> curr){
        if(source==target){
            curr.add(0,0);
            ans.add(new ArrayList<>(curr));
            curr.remove(0);
            return;
        }
        for(int i=0;i<graph[source].length;i++){
            curr.add(graph[source][i]);
            dfs(graph,graph[source][i],target,curr);
            curr.remove(curr.size()-1);
        }
        
    }
}