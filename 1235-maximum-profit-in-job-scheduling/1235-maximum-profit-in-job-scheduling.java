class Solution {
    private Map<Integer, Integer> dp;

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int[][] jobs = new int[startTime.length][3];
        for (int i = 0; i < startTime.length; i++) {
            jobs[i] = new int[] { startTime[i], endTime[i], profit[i] };
        }
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

        dp = new HashMap<>();
        return dfs(0, jobs);
    }

    private int dfs(int cur, int[][] jobs) {
        if (cur == jobs.length) {
            return 0;
        }

        if (dp.containsKey(cur)) {
            return dp.get(cur);
        }

        int next = findNext(cur, jobs);
        int inclProf = jobs[cur][2] + (next == -1 ? 0 : dfs(next, jobs));
        int exclProf = dfs(cur + 1, jobs);
        
        int maxProfit = Math.max(inclProf, exclProf);
        
        dp.put(cur, maxProfit);
        return maxProfit;
    }

    int findNext(int cur, int[][] jobs) {
        for (int next = cur + 1; next < jobs.length; next++) {
            if (jobs[next][0] >= jobs[cur][1]) {
                return next;
            }
        }
        return -1;
    }
}
