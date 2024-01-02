class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        int count[] = new int[nums.length+1];
        int max=0;
        for(int c : nums){
            count[c]++;
            max=Math.max(max,count[c]);
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<max;i++){
            List<Integer> temp = new ArrayList<>();
            for(int j=1;j<=nums.length;j++){
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