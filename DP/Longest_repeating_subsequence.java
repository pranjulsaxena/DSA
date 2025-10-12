package DP;
// simple variation of LCS.
public class Longest_repeating_subsequence {
    static  int LongestRepeatingSubsequence(String s) {
        if(s.isEmpty()){
            return 0;
        }
        return count(s,s);
    }
    static int count(String S1, String S2) {
        int m = S1.length();
        int n = S2.length();


        int[][] dp = new int[m + 1][n + 1];
        for(int i =0; i<=m; i++){
            for(int j=0; j<=n; j++){
                if(m==0||j==0){
                    dp[i][j]=0;
                }
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (S1.charAt(i - 1) == S2.charAt(j - 1)&&i!=j) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }


        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(LongestRepeatingSubsequence("AABEBCDD"));
    }
}
