class Solution {
    Set<List<Integer>> ans = new HashSet<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        recur(nums, 0, new ArrayList<>());
        return new ArrayList<>(ans);
    }
    
    void recur(int[] nums, int ind, List<Integer> curr){
        if(ind>=nums.length){
            if(curr.size()>=2){
                ans.add(new ArrayList<>(curr));
            }
            return;
        }
        
        if(curr.size()==0 || nums[ind]>=curr.get(curr.size()-1)){
            curr.add(nums[ind]);
            recur(nums,ind+1,curr);
            curr.remove(curr.size()-1);
        }
        recur(nums,ind+1,curr);
    }
}