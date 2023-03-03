class Solution {
    public int strStr(String haystack, String needle) {
        int k = needle.length();
        int n = haystack.length();
        if(k>n)
            return -1;
        int ans=-1;
        for(int i=0;i<=n-k;i++){
            int j=0;
            for(;j<k;j++){
                if(haystack.charAt(i+j)!=needle.charAt(j)){
                    break;
                }
            }
            if(j==k){
                ans=i;
            }
            if(ans!=-1)
                break;
        }
        
        return ans;
    }
}