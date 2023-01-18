class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int currSum1=0;
        int maxSum=nums[0];
        
        int currSum2=0;
        int minSum = nums[0];
        int total=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            currSum1+=nums[i];
            
            maxSum = Math.max(maxSum,currSum1);
            if(currSum1<0){
                currSum1=0;
            }
            
            currSum2+=nums[i];
            
            if(currSum2>0){
                currSum2=0;
            }
            minSum = Math.min(minSum,currSum2);
            
            total+=nums[i];
        }
        //System.out.println(total + " " + minSum + maxSum);
        if(total==minSum){
            return maxSum;
        }
        return Math.max(maxSum,total-minSum);
        
    }
}