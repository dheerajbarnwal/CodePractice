class Solution {
    public int minOperations(int[] nums) {
        Map<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(hm.containsKey(nums[i])){
                hm.put(nums[i],hm.get(nums[i])+1);
            }else{
                hm.put(nums[i],1);
            }
        }
        int ans=0;
        for(int v:hm.values()){
            if(v%3==0){
                ans+=v/3;
            }else if(v%3==2){
                ans+=(v/3)+1;
            }else if(v%3==1){
                v-=4;
                if(v<0){
                    return -1;
                }
                ans+=(v/3)+2;
            }
        }
        return ans;
    }
}