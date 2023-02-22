class Solution {
    int d,n;
    public int shipWithinDays(int[] weights, int days) {
        int total=0,max=0;
        d=days;
        n = weights.length;
        for(int i=0;i<n;i++){
            total+=weights[i];
            max=Math.max(max,weights[i]);
        }
        int low=max,high=total;
        
        while(low<high){
            int mid = (high+low)/2;
            //System.out.println(low + " " + high + " " + mid);
            if(possible(mid,weights)){
                //System.out.println("t");
                high=mid;
            }else{
                //System.out.println("f");
                low=mid+1;
            }
        }
        return low;
    }
    
    boolean possible(int c,int[] weights){
        int curr=0;
        int t=0;
        for(int i=0;i<n;i++){
            curr+=weights[i];
            if(curr>c){
                t++;
                if(curr!=weights[i])
                    i--;
                curr=0;
            }
        }
        if(curr!=0){
            t++;
        }
        if(t<=d){
            return true;
        }
        return false;
    }
}