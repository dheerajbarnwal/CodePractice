class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n=nums.length;
        int dp[] = new int[n];
        for(int i=0;i<n;i++){
            dp[i]=1;
        }
        for(int i=1;i<n;i++){
            int max=1;
            for(int j=i-1;j>=0;j--){
                if(nums[i]==nums[j]){
                    break;
                }
                if(nums[i]>nums[j]){
                    max = Math.max(dp[i]+dp[j],max);
                }
            }
            dp[i]=max;
            if(dp[i]>=3){
                return true;
            }
        }
        return false;
    }
}