class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] pp = new int[26];
        
        for(int i=0;i<p.length();i++){
            pp[p.charAt(i)-'a']++;
        }
        String ppp = Arrays.toString(pp);
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<=s.length()-p.length();i++){
            int[] t = new int[26];
            for(int j=i;j<i+p.length();j++){
                t[s.charAt(j)-'a']++;
            }
            
            if(ppp.equals(Arrays.toString(t))){
                ans.add(i);
            }
        }
        
        return ans;
    }
}