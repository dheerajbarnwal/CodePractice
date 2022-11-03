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
            String b = reverse(a);
            int fl=0;
            if(hm.containsKey(b) && hm.get(b)>0){
                ans+=4;
                //hm.put(a,1);
                hm.put(b,hm.get(b)-1);
                fl=1;
            }
            if(fl==0 && a.equals(b)){
                min=2;
            }
        }
        return Math.max(ans+min,min);
    }
    
    String reverse(String a){
        char[] t = a.toCharArray();
        char temp = t[0];
        t[0]=t[1];
        t[1]=temp;
        return String.valueOf(t);
    }
}
