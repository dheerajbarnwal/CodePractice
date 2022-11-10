class Solution {
    public String removeDuplicates(String s) {
        StringBuilder ans = new StringBuilder(s);
        int i = 0;
        while (i+1 < ans.length()) {
            if (isSame(ans.charAt(i), ans.charAt(i+1))) {
                ans.deleteCharAt(i);
                ans.deleteCharAt(i);
                i--;
                if (i == -1) {
                    i+=1;
                }
            } else {
                i+=1;
            }
        }
        return ans.toString();
    }
    
    boolean isSame(char a, char b) {
        return a==b;
    }
}