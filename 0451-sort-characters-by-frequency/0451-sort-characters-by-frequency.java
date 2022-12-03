class Solution {
    public String frequencySort(String s) {
        TreeMap<Integer,List<Character>> tm = new TreeMap<>(Collections.reverseOrder());
        Map<Character,Integer> hm = new HashMap<>();
        
        for(int i=0;i<s.length();i++){
            int count = hm.getOrDefault(s.charAt(i),0);
            hm.put(s.charAt(i),count+1);
        }
        
        for(Character c: hm.keySet()){
            int val = hm.get(c);
            List<Character> list;
            if(!tm.containsKey(val)){
                list = new ArrayList<>();
                tm.put(val,list);
            }
            
            tm.get(val).add(c);
            
        }
        
        StringBuilder sb = new StringBuilder();
        for(int val: tm.keySet()){
            List<Character> li = tm.get(val);
            for(Character c:li){
                for(int i=0;i<val;i++){
                    sb.append(c);
                }
            }
        }
        
        return sb.toString();
    }
}