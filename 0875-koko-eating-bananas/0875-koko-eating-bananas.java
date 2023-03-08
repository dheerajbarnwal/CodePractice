class Solution {
    int n;
    public int minEatingSpeed(int[] piles, int h) {
        int max=Integer.MIN_VALUE;
        n = piles.length;
        
        for(int i=0;i<n;i++){
            max= Math.max(max,piles[i]);
        }
        
        int low=1;
        int high=max;
        
        while(low<=high){
            int mid = low+(high-low)/2;
            if(check(mid,piles)<=(long)h){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;
    }
    
    long check(int mid,int[] piles){
        long t=0;
        for(int i=0;i<n;i++){
            t+=piles[i]/mid;
            if(piles[i]%mid!=0){
                t+=1;
            }
        }
        return t;
    }
}