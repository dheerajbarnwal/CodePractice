class Solution {
    int[] smallest;
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        smallest = new int[26];
        for(int i=0;i<26;i++){
            smallest[i]=i;
        }
        
        for(int i=0;i<s1.length();i++){
            union(s1.charAt(i)-'a',s2.charAt(i)-'a');
        }
        
        String ans="";
        
        for(int i=0;i<baseStr.length();i++){
            int t = find(baseStr.charAt(i)-'a');
            ans+=(char)(t+'a');
        }
        return ans;
    }
    
    void union(int x, int y){
        int rootx = find(x);
        int rooty = find(y);
        
        if(rootx!=rooty){
            if(rootx<rooty){
                smallest[rooty]=rootx;
            }else{
                smallest[rootx]=rooty;
            }
        }
    }
    
    int find(int x){
        while(x!=smallest[x]){
            x=smallest[x];
        }
        
        return x;
    }
}