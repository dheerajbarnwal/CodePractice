class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        int count[] = new int[201];
        int max=0;
        for(int i=0;i<nums.length;i++){
            count[nums[i]]++;
            max=Math.max(max,count[nums[i]]);
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<max;i++){
            List<Integer> temp = new ArrayList<>();
            for(int j=1;j<=200;j++){
                if(count[j]>0){
                    temp.add(j);
                    count[j]--;
                }
            }
            ans.add(temp);
        }
        return ans;
    }
}