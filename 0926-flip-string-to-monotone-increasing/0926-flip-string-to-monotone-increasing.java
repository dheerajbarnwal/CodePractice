class Solution {
    public int minFlipsMonoIncr(String s) {
        int n=s.length();
        int left1=0;
        int right0=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='0'){
                right0++;
            }
        }
        int ans=right0;
        for(int i=0;i<n;i++){
            char c = s.charAt(i);
            if(c=='0'){
                right0--;
            }else{
                left1++;
            }
            ans=Math.min(ans,left1+right0);
        }
        return ans;
    }
}