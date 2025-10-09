package DP;
// variation of LCS. Maximum Longest palindromic length for a string can be obtained
// by finding LCS of original string and reverse of original string.
public class Longest_Palindromic_Subsequence {
    static int count(String str){
        if (str.isEmpty()){
            return 0;
        }
        String reversed = new StringBuilder(str).reverse().toString();
        int [][]t = new int[str.length()+1][reversed.length()+1];
        return LCS(str,reversed,str.length(),reversed.length(),t);
    }
    static int LCS (String str1, String str2,int m, int n, int[][]t){
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
        return t[m][n];
    }

    public static void main(String[] args) {
        System.out.println(count("abcd"));
    }
}
