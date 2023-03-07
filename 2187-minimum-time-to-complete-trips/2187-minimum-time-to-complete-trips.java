class Solution {
    int max = Integer.MIN_VALUE;
    int n;
    public long minimumTime(int[] time, int totalTrips) {
        n = time.length;
        for(int i=0;i<n;i++){
            max= Math.max(max,time[i]);
        }
        
        long low = 1;
        long high = (long)max*totalTrips;
        while(low<=high){
            long mid = (low+high)/2;
            long temp = check(mid,time);
            if(temp>=totalTrips){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;
    }
    
    long check(long mid, int[] time){
        long l=0;
        for(int i=0;i<n;i++){
            l+=mid/time[i];
        }
        return l;
    }
}