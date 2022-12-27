class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int l=0;
        int[] count = new int[26];
        int ans=0;
        int max=0;
        for(int r=0;r<n;r++){
            max = Math.max(max,++count[s.charAt(r)-'A']);
            
            if(r-l+1-max>k){
                --count[s.charAt(l)-'A'];
                l++;
            }
            ans=Math.max(ans,r-l+1);
        }
        
        return ans;
    }
}