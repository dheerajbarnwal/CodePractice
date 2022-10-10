class Solution {
    public String breakPalindrome(String palindrome) {
        int n = palindrome.length();
        char[] ans= palindrome.toCharArray();
        if(n==1){
            return "";
        }
        int i=0;
        for(i=0;i<n;i++){
            if(ans[i]!='a'){
                if(i==n/2){
                    ans[n-1]='b';
                    return String.valueOf(ans);
                }
                ans[i]='a';
                return String.valueOf(ans);
            }
        }
        ans[i-1]='b';
        return String.valueOf(ans);
    }
}