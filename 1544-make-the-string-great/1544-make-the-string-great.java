class Solution {

    public String makeGood(String s) {
        char c[] = s.toCharArray();
        int n = c.length;
        int i = 0;
        int j = 1;
        while (j < n) {
            if (isSame(c[i], c[j])) {
                c[i] = '*';
                c[j] = '*';
                j++;
                while (i >= 0 && c[i] == '*') {
                    i--;
                }
                if (i == -1) {
                    i = j;
                    j = j + 1;
                }
            } else {
                i+=1;
                while(i<=j && c[i]=='*'){
                    i+=1;
                }
                j += 1;
            }
        }
        String ans = "";
        for (int k = 0; k < n; k++) {
            if (c[k] != '*') {
                ans += c[k];
            }
        }
        return ans;
    }

    boolean isSame(char a, char b) {
        if (Character.toUpperCase(a) == Character.toUpperCase(b)) {
            if (Character.isLowerCase(a) && !Character.isLowerCase(b)) {
                return true;
            }
            if (Character.isLowerCase(b) && !Character.isLowerCase(a)) {
                return true;
            }
        }
        return false;
    }
}
