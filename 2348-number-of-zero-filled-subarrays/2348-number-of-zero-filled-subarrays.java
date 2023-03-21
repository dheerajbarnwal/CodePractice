class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long ans=0;
        int n = nums.length;
        for(int i=0;i<n;){
            long count=0;
            while(i<n && nums[i]==0){
                count++;
                i++;
            }
            if(count==0){
                i++;
            }else{
                ans += (count*(count+1))/2;
            }
        }
        return ans;
    }
}