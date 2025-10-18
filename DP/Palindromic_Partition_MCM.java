package DP;


public class Palindromic_Partition_MCM {
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
    static Boolean isPalindrome(String str, int i, int j){
        if(i>=j){
            return true;
        }
        return (str.charAt(i)==str.charAt(j))&&isPalindrome(str,i+1,j-1);
    }

    public static void main(String[] args) {
        String str = "nitin";
        System.out.println(Solve(str,0,str.length()-1));
    }
}
