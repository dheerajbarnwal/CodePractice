class Solution {

    public int longestPalindrome(String[] words) {
        Map<String, Integer> hm = new HashMap<>();
        int n = words.length;

        for (int i = 0; i < n; i++) {
            hm.put(words[i],hm.getOrDefault(words[i],0)+1);
        }
        int ans = 0;
        int min = 0;
        for (int i = 0; i < n; i++) {
            String a = words[i];
            if(hm.get(a)<=0){
                continue;
            }
            hm.put(a,hm.get(a)-1);
            
            String b = "" + a.charAt(1) + a.charAt(0);
            if(hm.containsKey(b) && hm.get(b)>0){
                ans+=4;
                hm.put(b,hm.get(b)-1);
            }else if(a.equals(b)){
                min=2;
            }
        }
        return Math.max(ans+min,min);
    }
}
