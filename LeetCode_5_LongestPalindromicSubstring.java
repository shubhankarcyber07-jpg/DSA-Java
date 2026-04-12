public class LeetCode_5_LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        int a=-1, b=-1;
        for(int k=0; k<n; k++){
            for(int i=0, j=k; i<n-k && j<n; i++,j++){
                if(i==j){
                    dp[i][j] = 1;
                    a=i;b=j;
                }
                else if(i+1==j){
                    if(s.charAt(i)==s.charAt(j)){
                        dp[i][j] = 1;
                        a=i; b=j;
                    }
                }
                else{
                    if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]==1){
                        dp[i][j] = 1;
                        a=i; b=j;
                    }
                }
            }
        }
        return s.substring(a,b+1);
    }
}
