package DP;

public class Sequence_Pattern_Matching {
    static boolean issubsequence(String s, String t){
        int [][]dp = new int[s.length()+1][t.length()+1];
        String LCS=helper(s,t, s.length(),t.length(),dp);
        return s.equals(LCS);
    }
    static String helper(String str1, String str2, int m, int n, int [][]t){
        for(int i =0; i<=m; i++){
            for(int j =0; j<=n; j++){
                if(i==0||j==0){
                    t[i][j]=0;
                }
            }
        }
        for(int i =1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    t[i][j]=1+t[i-1][j-1];
                }else{
                    t[i][j]=Math.max(t[i-1][j],t[i][j-1]);
                }
            }
        }
        int i=m;
        int j=n;
        StringBuilder str = new StringBuilder();
        while(i>0 && j>0){
            if(str1.charAt(i-1)==str2.charAt(j-1)){
                str.append(str1.charAt(i-1));
                i--;
                j--;
            }else{
                if(t[i-1][j]>=t[i][j-1]){
                    i--;
                }else{
                    j--;
                }
            }
        }
        return str.reverse().toString();
    }

    // no need to compare LCS and required string. Because length of LCS --approach is sufficient.
    static boolean check(String S1, String S2) {
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
                if (S1.charAt(i - 1) == S2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                else {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        return dp[m][n]==S1.length();
    }

    public static void main(String[] args) {
        System.out.println(check("axc","ahbgdc"));
    }
}
