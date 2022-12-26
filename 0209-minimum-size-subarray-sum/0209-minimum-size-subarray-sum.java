class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n= nums.length;
        int l=0;
        int currSum=0;
        int ans=n+1;
        for(int r=0;r<n;r++){
            currSum+=nums[r];
            
            while(currSum>=target){
                ans=Math.min(ans,r-l+1);
                currSum-=nums[l];
                l++;
            }
        }
        if(ans==n+1)
            return 0;
        return ans;
    }
}