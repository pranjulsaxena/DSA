package DP;
// variation of longest common subsequence

public class Minimum_Number_of_Insertion_and_Deletion_to_convert_String_a_to_String_b {
    static int count(String str1, String str2){
        if(str1.isEmpty()) {
            return str2.length();
        }else if(str2.isEmpty()){
            return str1.length();
        }
        int [][]t = new int[str1.length()+1][str2.length()+1];
        int lcs = LCS(str1,str2,str1.length(),str2.length(),t);
        int m = str1.length();
        int n = str2.length();

    // min deletions + min insertions
        return (m-lcs)+(n-lcs);
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
        System.out.println(count("heap","pea"));
    }
}
