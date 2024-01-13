class Solution {
    public int minSteps(String s, String t) {
        int ss[] = new int[26];
        int tt[] = new int[26];
        
        for(int i=0;i<s.length();i++){
            ss[s.charAt(i)-'a']++;
            tt[t.charAt(i)-'a']++;
        }
        int ans=0;
        int rem=0;
        for(int i=0;i<26;i++){
            if(tt[i]<ss[i]){
                ans+=ss[i]-tt[i];
            }
            
        }
        
        return ans;
    }
}