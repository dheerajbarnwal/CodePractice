class Solution {
    public int minimumAverageDifference(int[] nums) {
        long sum=0;
        int n= nums.length;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        
        long leftSum=0;
        long min = Integer.MAX_VALUE;
        int ans=0;
        long rightSum=0;
        for(int i=0;i<n;i++){
            leftSum+=nums[i];
            rightSum = sum-leftSum;
            long diffAvg = Math.abs(leftSum / (i + 1) - (n - i -1== 0 ? 0 : rightSum / (n -i - 1)));
            
            if(diffAvg<min){
                min=diffAvg;
                ans=i;
            }
           
        }
        
        return ans;
    }
}