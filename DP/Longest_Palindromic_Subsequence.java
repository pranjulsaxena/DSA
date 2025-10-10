package DP;

import java.util.Arrays;

// variation of LCS. Maximum Longest palindromic length for a string can be obtained
// by finding LCS of original string and reverse of original string.
public class Longest_Palindromic_Subsequence {
    static int count(String str) {
        if (str.isEmpty()) {
            return 0;
        }
        String reversed = new StringBuilder(str).reverse().toString();
        int[][] t = new int[str.length() + 1][reversed.length() + 1];
        return LCS(str, reversed, str.length(), reversed.length(), t);
    }

    static int LCS(String str1, String str2, int m, int n, int[][] t) {
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    t[i][j] = 0;
                }
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    t[i][j] = 1 + t[i - 1][j - 1];
                } else {
                    t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
                }
            }
        }
        return t[m][n];
    }

    // without LCS
    // recursive approach
    static int recursive(String s) {
        return helper_recursive(s, 0, s.length() - 1);
    }

    static int helper_recursive(String str, int low, int high) {
        if (low > high) {
            return 0;
        }
        if (low == high) {
            return 1;
        }
        if (str.charAt(low) == str.charAt(high)) {
            return 2 + helper_recursive(str, low + 1, high - 1);
        } else {
            return Math.max(helper_recursive(str, low + 1, high), helper_recursive(str, low, high - 1));
        }
    }

    static int Memoization(String str) {
        int[][] t = new int[str.length()][str.length()];
        for(int[] i:t){
            Arrays.fill(i,-1);
        }
        int ans= helper_Memoization(str, 0, str.length()-1, t);
        for(int[] i:t){
            System.out.println(Arrays.toString(i));
        }
        return ans;
    }

    static int helper_Memoization(String str, int low, int high, int[][] t) {
        if (t[low][high] != -1) {
            return t[low][high];
        }
        if (low > high) {
            return 0;
        }
        if (low == high) {
            return 1;
        }
        if (str.charAt(low) == str.charAt(high)) {
            t[low][high] = 2 + helper_Memoization(str, low + 1, high - 1, t);
        } else {
            t[low][high] = Math.max(helper_Memoization(str, low + 1, high, t), helper_Memoization(str, low, high - 1, t));
        }
        return t[low][high];
    }
    // tabulation method
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
        System.out.println(LPS("bbabcbcab"));
    }
}