class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        Map<String,List<String>> hm = new HashMap();
        for(int i=0;i<n;i++){
            String str = strs[i];
            int a[] = new int[26];
            //System.out.println(str + " " + str.length());
            for(int j=0;j<str.length();j++){
                a[str.charAt(j)-'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<26;j++){
                //System.out.println(a[j]);
                sb.append(a[j]).append(" ");
            }
            String key = sb.toString();
            //System.out.println(key);
            if(!hm.containsKey(key)){
                hm.put(key,new ArrayList<>());
            }
            hm.get(key).add(str);
        }
        
        return new ArrayList<>(hm.values());
    }
}