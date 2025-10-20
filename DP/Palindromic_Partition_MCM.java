package DP;


import java.util.Arrays;

public class Palindromic_Partition_MCM {
    // recursive MCM
    static int Solve(String str, int i, int j){
        if(i>=j){
            return 0; // zero partition for one character.
        }
        int min = Integer.MAX_VALUE;
        for(int k =i; k<j; k++){
            if(isPalindrome(str,i,j)){
                return 0; // if whole substring palindrome . no partition
            }
            int ans = Solve(str,i,k) + Solve(str,k+1,j)+1;
            min = Math.min(ans,min);
        }
        return min;
    }
    // Memoization
    static int Memo(String str, int i, int j, int[][]dp){
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(i>=j){
            return 0;
        }
        if(isPalindrome(str,i,j)){
            return 0; // if whole substring palindrome . no partition
        }
        int min = Integer.MAX_VALUE;
        for(int k=i; k<j; k++){

            int ans = Memo(str, i,k,dp) + Memo(str,k+1,j,dp)+1;
            min = Math.min(ans, min);
        }
        dp[i][j]=min;
        return dp[i][j];
    }
    static Boolean isPalindrome(String str, int i, int j){
        if(i>=j){
            return true;
        }
        return (str.charAt(i)==str.charAt(j))&&isPalindrome(str,i+1,j-1);
    }

    public static void main(String[] args) {
        String str = "geek";
        int [][]dp = new int[str.length()+1][str.length()+1];
        for(int[]i :dp){
            Arrays.fill(i,-1);
        }
        System.out.println(Memo(str,0,str.length()-1,dp));
    }
}
