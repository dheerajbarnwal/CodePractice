class Solution {

    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> hm = new HashMap<>();
        int k = 0;
        int n = fruits.length;
        int ans = 0;
        int start = 0;
        for (int i = 0; i < n; i++) {
            int num = fruits[i];
            hm.put(num, hm.getOrDefault(num, 0) + 1);
            while (hm.size() >= 3) {
                int count = hm.get(fruits[start]);
                if (count == 1) {
                    hm.remove(fruits[start]);
                } else {
                    hm.put(fruits[start], count - 1);
                }
                start++;
            }
            ans = Math.max(ans, i - start + 1);
        }
        return ans;
    }
}
