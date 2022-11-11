class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if(n==1){
            return 1;
        }
        int i=1;
        int j=1;
        int curr = nums[0];
        while(i<n){
            while(i<n && nums[i]==curr){
                i++;
            }
            
            if(i<n){
                curr=nums[i];
                nums[j]=nums[i];
            }
            j++;
        }
        return j-1;
    }
}