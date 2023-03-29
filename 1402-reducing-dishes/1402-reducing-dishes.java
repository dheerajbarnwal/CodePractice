class Solution {
    public int maxSatisfaction(int[] s) {
        int n = s.length;
        int sum =0;
        int ans=0;
        Arrays.sort(s);
        for(int i=n-1;i>=0;i--){
            if(s[i]+sum>0){
                sum+=s[i];
                ans+=sum;
            }else{
                break;
            }
        }
        return ans;
    }
}