package DP;

public class Knapsack_01 {
    // using recursion only
    static int solve(int []wt,int []val,int W,int n){
        if(n==0||W==0){
            return 0;
        }
        if(wt[n-1]<=W){
            return Math.max(val[n-1]+solve(wt,val,W-wt[n-1],n-1),solve(wt,val,W,n-1));
        }else{
            return solve(wt,val,W,n-1);
        }
    }

    public static void main(String[] args) {
        int[] val = {1, 7, 11};
        int[] wt = {1, 2, 3};
        int W = 5;

        System.out.println(solve(wt,val,W,val.length));
    }
}