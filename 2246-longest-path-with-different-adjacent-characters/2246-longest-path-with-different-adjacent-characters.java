class Solution {
    int ans=1;
    public int longestPath(int[] parent, String s) {
        Map<Integer,List<Integer>> adj = new HashMap<>();
        
        for(int i=0;i<parent.length;i++){
            adj.computeIfAbsent(parent[i],val->new ArrayList<Integer>()).add(i);
        }
        
        dfs(0,adj,s);
        return ans;
    }
    
    int dfs(int node, Map<Integer,List<Integer>> adj, String s){
        if(!adj.containsKey(node)){
            return 1;
        }
        
        int longest=0;
        int secondLongest=0;
        for(int child:adj.get(node)){
            int temp = dfs(child,adj,s);
            if(s.charAt(child)!=s.charAt(node)){
                if(temp>longest){
                    secondLongest=longest;
                    longest=temp;
                }else{
                    secondLongest=Math.max(secondLongest,temp);
                }
            }
            
        }
        ans=Math.max(ans,longest+secondLongest+1);
        return longest+1;
    }
}