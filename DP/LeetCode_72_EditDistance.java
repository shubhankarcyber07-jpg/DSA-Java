import java.util.Arrays;

public class LeetCode_72_EditDistance {
    public int minStep(int i, int j, StringBuilder a, StringBuilder b, int[][] dp){
        if(i<0) return j+1;
        if(j<0) return i+1;
        if(dp[i][j]!=-1) return dp[i][j];
        if(a.charAt(i)==b.charAt(j)) return dp[i][j] = minStep(i-1, j-1, a, b, dp);
        else{
            int del = minStep(i-1, j, a, b, dp);
            int ins = minStep(i, j-1, a, b, dp);
            int rep = minStep(i-1, j-1, a, b, dp);
            return dp[i][j] = 1 + Math.min(del, Math.min(ins,rep));
        }
    }
    public int minDistance(String word1, String word2) {
        StringBuilder a = new StringBuilder(word1);
        StringBuilder b = new StringBuilder(word2);
        int m = a.length();
        int n = b.length();
        int[][] dp = new int[m][n];
        for(int i=0; i<m; i++){
            Arrays.fill(dp[i], -1);
        }
        return minStep(m-1, n-1, a, b, dp);
    }
}
