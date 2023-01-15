class Solution {
    public long countGood(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        
        int c=0;
        long ans=0;
        int i=0;
        int n= nums.length;
        for(int j=0;j<nums.length;j++){
            if(!map.containsKey(nums[j])){
                map.put(nums[j],0);
            }
            map.put(nums[j],map.get(nums[j])+1);
            int size=map.get(nums[j]);
            if(size>=2){
                c+=size-1;
            }
            if(c>=k){
                ans++;
                ans+=n-j-1;
            }
            //System.out.println(j+" "+ans);
            while(i<n && c>=k){
                map.put(nums[i],map.get(nums[i])-1);
                if(map.get(nums[i])>=1){
                    c-=map.get(nums[i]);
                }
                if(c>=k){
                    ans++;
                    ans+=n-j-1;
                }
                //System.out.println(ans);
                i++;
            }
        }
        // int kk=4600719989;
        // System.out.println(kk);
        return ans;
    }
}