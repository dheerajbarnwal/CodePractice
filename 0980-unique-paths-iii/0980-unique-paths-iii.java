class Solution {
    int dir[][] = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
    int si, sj;
    int ans = 0;
    int m, n;
    int empty = 0;

    public int uniquePathsIII(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    si = i;
                    sj = j;
                    empty++;
                } else if (grid[i][j] == 0) {
                    empty++;
                }
            }
        }
        dfs(grid, si, sj, 0);
        return ans;
    }

    void dfs(int[][] grid, int si, int sj, int curr) {
        if (grid[si][sj] == 2) {
            if (curr == empty) {
                ans++;
            }
            return;
        }
        grid[si][sj] = -1;
        for (int i = 0; i < 4; i++) {
            int ni = si + dir[i][0];
            int nj = sj + dir[i][1];
            if (ni < 0 || ni >= m || nj < 0 || nj >= n || grid[ni][nj] == -1) {
                continue;
            }
            dfs(grid, ni, nj, curr + 1);
        }
        grid[si][sj] = 0;
    }
}
