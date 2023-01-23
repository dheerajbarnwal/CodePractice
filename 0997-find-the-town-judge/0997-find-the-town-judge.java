class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] arr = new int[n+1];
        
        for(int i=0;i<trust.length;i++){
            arr[trust[i][0]]=1;
        }
        int ans=-1;
        for(int i=1;i<=n;i++){
            if(arr[i]==0){
                ans= i;
            }
        }
        int count=0;
        for(int i=0;i<trust.length;i++){
            if(trust[i][1]==ans){
                count++;
            }
        }
        if(count==n-1){
            return ans;
        }
        
        return -1;
    }
}