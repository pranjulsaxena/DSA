package DP;

public class Palindromic_Partition_Recursion {
    // recursive solution.
    static int Solve(String str){
        if(str.isEmpty()){
            return -1;
        }
        return helper(str, 0,str.length()-1);
    }
    static int helper(String str, int start, int end){
        if(start==end){
            return 0;
        }

        int min = Integer.MAX_VALUE;
        for(int i=start; i<=end;i++){
            if(checkPalindrome(str,start,end)){
                return 0;
            }
            if(checkPalindrome(str,start,i)){
                int ans = 1+helper(str,i+1,end);
                min=Math.min(ans,min);
            }
        }
        return min;
    }

    static boolean checkPalindrome(String str, int start, int end){
        if(start>=end){
            return true;
        }
        return str.charAt(start) == str.charAt(end) && checkPalindrome(str, start + 1, end - 1);
    }

    public static void main(String[] args) {
        System.out.println(Solve("aaaa"));
    }
}

