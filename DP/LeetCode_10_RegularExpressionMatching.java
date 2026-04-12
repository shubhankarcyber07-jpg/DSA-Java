public class LeetCode_10_RegularExpressionMatching {
    // public boolean isMatch(String s, String p) {
    //     return solve(0, 0, s, p);
    // }

    // public boolean solve(int i, int j, String s, String p){
    //     if(j == p.length()) return i == s.length();

    //     boolean match = (i < s.length() &&
    //             (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'));

    //     if(j + 1 < p.length() && p.charAt(j + 1) == '*'){
    //         return solve(i, j + 2, s, p) ||   // skip *
    //                (match && solve(i + 1, j, s, p)); // use *
    //     }

    //     if(match) return solve(i + 1, j + 1, s, p);

    //     return false;
    // }
    Boolean[][] dp;

    public boolean isMatch(String s, String p) {
        dp = new Boolean[s.length()][p.length()];
        return solve(0, 0, s, p);
    }

    public boolean solve(int i, int j, String s, String p){

        // base case
        if(j == p.length())
            return i == s.length();

        // memo check
        if(i < s.length() && dp[i][j] != null)
            return dp[i][j];

        boolean match = (i < s.length() &&
                (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'));

        boolean ans;

        if(j + 1 < p.length() && p.charAt(j + 1) == '*'){
            ans = solve(i, j + 2, s, p) ||   // skip *
                (match && solve(i + 1, j, s, p)); // use *
        } else {
            ans = match && solve(i + 1, j + 1, s, p);
        }

        if(i < s.length())
            dp[i][j] = ans;

        return ans;
    }
}
