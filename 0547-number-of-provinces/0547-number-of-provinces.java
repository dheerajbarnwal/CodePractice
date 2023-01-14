class Solution {
    int[] root;
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        root = new int[n];
        for(int i=0;i<n;i++){
            root[i]=i;
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j]==1){
                    union(i,j);
                }
            }
        }
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(find(i));
        }
        
        return set.size();
        
    }
    
    void union(int x, int y){
        int rootx = find(x);
        int rooty=find(y);
        if(rootx!=rooty){
            root[rooty]=rootx;
        }
    }
    
    int find(int x){
        while(x!=root[x]){
            x=root[x];
        }
        return x;
    }
}