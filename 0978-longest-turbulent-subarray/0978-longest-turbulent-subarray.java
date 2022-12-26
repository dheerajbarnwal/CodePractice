class Solution {
    public int maxTurbulenceSize(int[] arr) {
        
        int n=arr.length;
        if(n==1){
            return 1;
        }
        int curr=arr[0]!=arr[1]?2:1;
        int max=curr;
        
        int prevSign=Integer.compare(arr[0],arr[1]);
        int postSign;
        
        for(int i=1;i<n-1;i++){
            postSign = Integer.compare(arr[i],arr[i+1]);
            if(prevSign*postSign<0){
                curr++;
            }else {
                curr=1;
                if(postSign!=0){
                    curr+=1;
                }
            }
            prevSign=postSign;
            max=Math.max(max,curr);
        }
        return max;
        
    }
}