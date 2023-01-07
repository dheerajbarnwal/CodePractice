class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n= gas.length;
        int sum=0;
        int currSum=0;
        int ans=0;
        for(int i=0;i<n;i++){
            sum+=gas[i]-cost[i];
            currSum+=gas[i]-cost[i];
            if(currSum<0){
                currSum=0;
                ans=i+1;
            }
        }
        if(sum>=0)
            return ans;
        return -1;
    }
}