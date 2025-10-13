package DP;

public class minimum_no_of_insertions_to_make_string_palindrome {
    static int insertions(String s){
        if(s.isEmpty()){
            return 0;
        }
        int size = s.length();
        int LPS = LPS(s);
        return size-LPS;
    }
    public static int LPS(String S) {
        int[][] dp = new int[S.length()][S.length()];

        for (int i = S.length() - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i+1; j < S.length(); j++) {
                if (S.charAt(i) == S.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][S.length()-1];
    }

    public static void main(String[] args) {
        System.out.println(insertions("leetcode"));
    }
}
