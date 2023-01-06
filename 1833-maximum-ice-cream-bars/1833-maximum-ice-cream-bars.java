class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int n = costs.length;
        int ans=0;
        
        int i=0;
        while(i<n && coins-costs[i]>=0){
            ans++;
            coins-=costs[i];
            i++;
        }
        return ans;
        
    }
}