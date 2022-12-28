class Solution {
    public int minStoneSum(int[] piles, int k) {
        int n=piles.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        int sum=0;
        for(int i=0;i<n;i++){
            pq.add(piles[i]);
            sum+=piles[i];
        }
        int ans=0;
        while(k>0){
            int t = pq.poll();
            ans+=t/2;
            pq.add(t-t/2);
            k--;
        }
        
        return sum-ans;
    }
}