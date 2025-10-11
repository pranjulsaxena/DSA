package DP;
// little variation of printing lcs. We only add matched characters once and also add characters those are not matched
public class print_shortest_common_supersequence {
    static void Print(String str1, String str2){
        int [][]t = new int[str1.length()+1][str2.length()+1];
        helper(str1,str2, str1.length(),str2.length(),t);
    }
    static void helper(String str1, String str2, int m, int n, int [][]t){
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
                    str.append(str1.charAt(i-1));
                    i--;
                }else{
                    str.append(str2.charAt(j-1));
                    j--;
                }
            }
        }
        System.out.println(str.reverse());
    }

    public static void main(String[] args) {
        Print("acbcf", "abcdaf");
    }
}
