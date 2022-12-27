class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = capacity.length;
        int[] diff = new int[n];
        
        int ans=0;
        for(int i=0;i<n;i++){
            diff[i]=capacity[i]-rocks[i];
        }
        
        Arrays.sort(diff);
        
        for(int i=0;i<n;i++){
            if(diff[i]<=additionalRocks){
                ans++;
                additionalRocks-=diff[i];
            }else{
                break;
            }
        }
        return ans;
    }
}