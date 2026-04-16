public class LeetCode_63_UniquePathsII {
    public int uniquePathsWithObstacles(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        
        // If start or end is blocked, no paths
        if (arr[0][0] == 1 || arr[m-1][n-1] == 1) return 0;
        
        int[][] dp = new int[m][n];
        
        // Initialize first cell
        dp[0][0] = 1;
        
        // First row
        for (int j = 1; j < n; j++) {
            if (arr[0][j] == 1) dp[0][j] = 0;
            else dp[0][j] = dp[0][j-1];
        }
        
        // First column
        for (int i = 1; i < m; i++) {
            if (arr[i][0] == 1) dp[i][0] = 0;
            else dp[i][0] = dp[i-1][0];
        }
        
        // Fill the rest
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (arr[i][j] == 1) dp[i][j] = 0;
                else dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        
        return dp[m-1][n-1];
    }
}
