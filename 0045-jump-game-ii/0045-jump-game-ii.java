class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        
        
        for(int i=0;i<n;i++){
            dp[i]=10000;
        }
        dp[0]=0;
        for(int i=1;i<n;i++){
            for(int j=i-1;j>=0;j--){
                if(j+nums[j]>=i){
                    dp[i]=Math.min(dp[i],dp[j]+1);
                }
                
            }
        }
        
        return dp[n-1];
    }
}