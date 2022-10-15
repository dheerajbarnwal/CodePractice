class Solution {
    int[][][][] memo;
    Set<Integer> add = Set.of(1, 9, 99);

    public int getLengthOfOptimalCompression(String s, int k) {
        int n = s.length();
        memo = new int[n][27][n + 1][k + 1];
        Arrays.stream(memo).forEach(a -> Arrays.stream(a).forEach(b -> Arrays.stream(b).forEach(c -> Arrays.fill(c, Integer.MAX_VALUE))));
        return dp(s, 0, (char) ('a' + 26), 0, k);
    }

    private int dp(String s, int idx, char lastChar, int lastCharCount, int k) {
        if (k < 0) {
            return Integer.MAX_VALUE / 2;
        }

        if (idx == s.length()) {
            return 0;
        }

        if (memo[idx][lastChar - 'a'][lastCharCount][k] != Integer.MAX_VALUE) {
            //System.out.println("ok");
            return memo[idx][lastChar - 'a'][lastCharCount][k];
        }

        int keepChar;
        int deleteChar = dp(s, idx + 1, lastChar, lastCharCount, k - 1);
        if (s.charAt(idx) == lastChar) {
            keepChar = dp(s, idx + 1, lastChar, lastCharCount + 1, k) + (add.contains(lastCharCount) ? 1 : 0);
        } else {
            keepChar = dp(s, idx + 1, s.charAt(idx), 1, k) + 1;
        }
        int res = Math.min(keepChar, deleteChar);
        memo[idx][lastChar - 'a'][lastCharCount][k] = res;

        return res;
    }
}
