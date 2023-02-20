class Solution {
    public int searchInsert(int[] nums, int target) {
        
        int n=nums.length;
        int i=0;
        int j=n-1;
        while(i<=j){
            int mid = (i+j)/2;
            if(nums[mid]==target){
                return mid;
            }else if(target>nums[mid]){
                i=mid+1;
            }else{
                j=mid-1;
            }
        }
        return i;
    }
}