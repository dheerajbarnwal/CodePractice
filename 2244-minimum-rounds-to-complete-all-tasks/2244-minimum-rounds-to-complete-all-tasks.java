class Solution {
    public int minimumRounds(int[] tasks) {
        Map<Integer,Integer> freq = new HashMap<>();
        int n=tasks.length;
        
        for(int i=0;i<n;i++){
            freq.put(tasks[i],freq.getOrDefault(tasks[i],0)+1);
        }
        
        int ans=0;
        for(Integer val:freq.values()){
            if(val==1){
                return -1;
            }
            int rem = val%3;
            if(rem==0){
                ans+=val/3;
            }else{
                ans+=val/3;
                ans+=1;
            }
            
        }
        return ans;
        
    }
}