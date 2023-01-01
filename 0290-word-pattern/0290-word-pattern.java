class Solution {
    public boolean wordPattern(String pattern, String s) {
        int m = pattern.length();
        String[] arr = s.split(" ");
        int n = arr.length;
        if(m!=n)
            return false;
        Map<Character,String> hm = new HashMap<>();
        Set<String> hs = new HashSet<>();
        for(int i=0;i<m;i++){
            char c = pattern.charAt(i);
            if(hm.containsKey(c)){
                if(!arr[i].equals(hm.get(c))){
                    return false;
                }
            }else{
                if(hs.contains(arr[i])){
                    return false;
                }
                hm.put(c,arr[i]);
                hs.add(arr[i]);
            }
        }
        return true;
    }
}