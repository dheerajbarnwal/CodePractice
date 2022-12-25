class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        int n = nums.length;
        Arrays.sort(nums);
        int[] prefixSum = new int[n];
        
        for(int i=0;i<n;i++){
            prefixSum[i] = (i-1>=0?prefixSum[i-1]:0)+nums[i];
        }
        
        int m = queries.length;
        int[] ans = new int[m];
        
        for(int i=0;i<m;i++){
            if(queries[i]<prefixSum[0]){
                ans[i]= 0;
                continue;
            }
            if(queries[i]>prefixSum[n-1]){
                ans[i]= n;
                continue;
            }
            int ind = search(queries[i],prefixSum);
            ans[i]=ind;
        }
        
        return ans;
    }
    
    int search(int num, int[] p){
        int i=0;
        int j = p.length-1;
        
        while(i<=j){
            int mid = i+(j-i)/2;
            if(p[mid]==num || (((mid + 1) >= p.length || p[mid + 1] > num) && ((mid - 1) < 0 || p[mid - 1] < num))){
                if(p[mid]>num){
                    return mid;
                }
//                 else if(p[mid]<num){
                    
//                 }
                return mid+1;
            }else if(p[mid]>num){
                j=mid-1;
            }else{
                i = mid+1;
            }
        }
        return 0;
    }
}