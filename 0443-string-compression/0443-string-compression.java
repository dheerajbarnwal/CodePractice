class Solution {

    public int compress(char[] chars) {
        int n = chars.length;

        int i = 1;
        int j = 0;
        char prev = chars[0];
        int count = 1;
        while (i < n) {
            if (chars[i] == chars[i - 1]) {
                count++;
            } else {
                if (count == 1) {
                    chars[j++] = chars[i - 1];
                } else {
                    chars[j++] = chars[i - 1];
                    String s = String.valueOf(count);
                    for (int k = 0; k < s.length(); k++) {
                        chars[j++] = s.charAt(k);
                    }
                }
                count = 1;
            }
            i++;
        }

        if (count == 1) {
            chars[j++] = chars[i - 1];
        } else {
            chars[j++] = chars[i - 1];
            String s = String.valueOf(count);
            for (int k = 0; k < s.length(); k++) {
                chars[j++] = s.charAt(k);
            }
        }

        return j;
    }
}
