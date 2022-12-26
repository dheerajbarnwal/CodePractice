class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int n=arr.length;
        int l=0;
        int currSum=0;
        int ans=0;
        for(int r=0;r<n;r++){
            currSum+=arr[r];
            if(r-l+1>k){
                currSum-=arr[l];
                l++;
            }
            if(r-l+1==k){
                if(currSum/k>=threshold){
                    ans++;
                }
            }
        }
        return ans;
    }
}