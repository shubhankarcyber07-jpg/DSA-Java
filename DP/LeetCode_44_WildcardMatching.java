public class LeetCode_44_WildcardMatching {
    // Boolean[][] dp;

    // public boolean solve(int i, int j, String s, String p){

    //     if(j == p.length())
    //         return i == s.length();

    //     if(dp[i][j] != null)
    //         return dp[i][j];

    //     boolean match = (i < s.length() &&
    //             (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?'));

    //     boolean ans;

    //     if(p.charAt(j) == '*'){
    //         ans = solve(i, j + 1, s, p) ||   // skip *
    //               (i < s.length() && solve(i + 1, j, s, p)); // use *
    //     } 
    //     else {
    //         ans = match && solve(i + 1, j + 1, s, p);
    //     }

    //     return dp[i][j] = ans;
    // }

    // public boolean isMatch(String s, String p) {
    //     dp = new Boolean[s.length() + 1][p.length() + 1];
    //     return solve(0, 0, s, p);
    // }
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();

        boolean[][] dp = new boolean[n + 1][m + 1];

        dp[0][0] = true;

        // handle pattern starting with *
        for(int j = 1; j <= m; j++){
            if(p.charAt(j - 1) == '*'){
                dp[0][j] = dp[0][j - 1];
            }
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){

                if(p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '?'){
                    dp[i][j] = dp[i - 1][j - 1];
                }

                else if(p.charAt(j - 1) == '*'){
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }

                else{
                    dp[i][j] = false;
                }
            }
        }

        return dp[n][m];
    }
}
