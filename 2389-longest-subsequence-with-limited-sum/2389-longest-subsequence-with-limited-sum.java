class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        int n = nums.length;
        Arrays.sort(nums);
        
        for(int i=1;i<n;i++){
            nums[i] += nums[i-1];
        }
        
        int m = queries.length;
        int[] ans = new int[m];
        
        for(int i=0;i<m;i++){
            int ind = search(nums,queries[i]);
            ans[i]=ind;
        }
        
        return ans;
    }
    
    int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target)
                return mid + 1;
            if (nums[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return nums[left] > target ? left : left + 1;
    }
}