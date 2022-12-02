class Solution {
    int arr1[] = new int[26];
    int arr2[] = new int[26];
    public boolean closeStrings(String word1, String word2) {
        if(op1(word1,word2) || op2(word1,word2)){
            return true;
        }
        return false;
    }
    
    boolean op1(String w1, String w2){
        
        for(int i=0;i<w1.length();i++){
            arr1[w1.charAt(i)-'a']++;
        }
        
        for(int i=0;i<w2.length();i++){
            arr2[w2.charAt(i)-'a']++;
        }
        
        for(int i=0;i<26;i++){
            if(arr1[i]!=arr2[i]){
                return false;
            }
        }
        
        return true;
    }
    
    boolean op2(String w1, String w2){
        
        Map<Integer,Integer> map1 = new HashMap<>();
        Map<Integer,Integer> map2 = new HashMap<>();
        
        for(int i=0;i<26;i++){
            
            if((arr1[i]!=0 && arr2[i]==0) ||(arr2[i]!=0 && arr1[i]==0)){
                return false;
            }
            int count1 = map1.getOrDefault(arr1[i],0);
            map1.put(arr1[i],count1+1);
            
            int count2 = map2.getOrDefault(arr2[i],0);
            map2.put(arr2[i],count2+1);
            
            
        }
        
        for(int key: map1.keySet()){
            if(map2.containsKey(key) && map2.get(key)==map1.get(key)){
                continue;
            }else{
                return false;
            }
        }
        
        
        
        return true;
    }
}