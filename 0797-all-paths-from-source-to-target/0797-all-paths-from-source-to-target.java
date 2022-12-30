class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(graph,0,n-1,path);
        return ans;
    }
    
    void dfs(int[][] graph, int source, int target, List<Integer> curr){
        if(source==target){
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int i=0;i<graph[source].length;i++){
            curr.add(graph[source][i]);
            dfs(graph,graph[source][i],target,curr);
            curr.remove(curr.size()-1);
        }
        
    }
}