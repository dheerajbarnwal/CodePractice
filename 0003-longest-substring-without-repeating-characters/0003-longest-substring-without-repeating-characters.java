class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        int l=0;
        int ans=0;
        Map<Character, Integer> hm = new HashMap<>();
        for(int r=0;r<n;r++){
            char c = s.charAt(r);
            
            if(hm.containsKey(c)){
                int ind = hm.get(c);
                
                for(int i=l;i<=ind;i++){
                    hm.remove(s.charAt(i));
                }
                l=ind+1;
            }
            
            ans = Math.max(ans,r-l+1);
            hm.put(c,r);
        }
        
        return ans;
    }
}