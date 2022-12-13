class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        dp[0]=matrix[0];
        
        for(int i=1;i<n;i++){
            for(int j=0;j<n;j++){
                int first = j-1>=0?dp[i-1][j-1]:Integer.MAX_VALUE;
                int second = dp[i-1][j];
                int third = j+1<n?dp[i-1][j+1]:Integer.MAX_VALUE;
                
                int min = Math.min(Math.min(first,second),third);
                dp[i][j] = matrix[i][j] + min;
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int j=0;j<n;j++){
            ans = Math.min(ans,dp[n-1][j]);
        }
        
        return ans;
    }
}