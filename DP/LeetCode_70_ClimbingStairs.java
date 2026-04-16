public class LeetCode_70_ClimbingStairs {
    // public int climb(int n, int[] dp){
    //     if(n<=2) return n;
    //     if(dp[n]!=0) return dp[n];
    //     return dp[n] = climb(n-1, dp) + climb(n-2, dp);
    // }
    // public int climbStairs(int n) {
    //     int[] dp = new int[n+1];
    //     if(dp[n]!=0) return dp[n];
    //     return climb(n,dp);
    // }
    public int climbStairs(int n){
        if(n<=2) return n;
        int[] dp = new int[n+1];
        dp[1] = 1; dp[2] = 2;
        for(int i=3; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
