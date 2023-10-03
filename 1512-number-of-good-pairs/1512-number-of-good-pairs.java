class Solution {
    public int numIdenticalPairs(int[] nums) {
        int ans=0;
        Map<Integer,Integer> hm = new HashMap<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }
        for(int i:hm.values()){
            ans+=(i*(i-1))/2;
        }
        return ans;
    }
}