class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        Map<Integer,List<Integer>> adj = new HashMap<>();
        for(int[] edge:edges){
            int a = edge[0];
            int b = edge[1];
            adj.computeIfAbsent(a,val->new ArrayList<Integer>()).add(b);
            adj.computeIfAbsent(b,val->new ArrayList<Integer>()).add(a);
        }
        
        int[] ans = new int[n];
        dfs(0,-1,adj,labels,ans);
        return ans;
    }
    
    int[] dfs(int node, int par, Map<Integer,List<Integer>> adj, String labels,int[] ans){
        // Store count of all alphabets in the subtree of the node.
        int[] nodeCounts = new int[26];
        nodeCounts[labels.charAt(node) - 'a'] = 1;
        
        if(!adj.containsKey(node)){
            return nodeCounts;
        }
        List<Integer> child = adj.get(node);
        for(Integer c:child){
            if(c==par){
                continue;
            }
            int[] childCounts = dfs(c,node,adj,labels,ans);
            for (int i = 0; i < 26; i++) {
                nodeCounts[i] += childCounts[i];
            }
        }
        
        ans[node] = nodeCounts[labels.charAt(node) - 'a'];
        return nodeCounts;
    }
}