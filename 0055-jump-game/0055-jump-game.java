class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int target=n-1;
        
        while(target!=0){
            int start=target-1;
            while(start>=0 && start+nums[start]<target){
                start--;
            }
            
            if(start<0 && target!=0){
                return false;
            }
            
            target=start;
            
        }
        return true;
    }
}