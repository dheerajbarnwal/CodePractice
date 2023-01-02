class Solution {
    public boolean detectCapitalUse(String word) {
        int n = word.length();
        int small=0;
        int big=0;
        int bigi=-1;
        for(int i=0;i<n;i++){
            char c = word.charAt(i);
            if(c>='a' && c<='z'){
                small++;
            }else if(c>='A' && c<='Z'){
                big++;
                bigi=i;
            }
        }
        if(small==n || big==n || (big==1 && bigi==0 && small==n-1)){
            return true;
        }
        return false;
    }
}