package DP;

import java.util.Arrays;

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
    // memoization
    static int Solved(int []wt,int []val,int W,int n,int [][]t){
        if(n==0||W==0){
            return 0;
        }
        if(t[n][W]!=-1){
            return t[n][W];
        }
        if(wt[n-1]<=W){
            return t[n][W]=Math.max(val[n-1]+solve(wt,val,W-wt[n-1],n-1),solve(wt,val,W,n-1));
        }else{
            return t[n][W]=solve(wt,val,W,n-1);
        }
    }


    public static void main(String[] args) {
        int[] val = {1, 7, 11};
        int[] wt = {1, 2, 3};
        int W = 5;

//        System.out.println(solve(wt,val,W,val.length));
        int t[][]= new int[val.length+1][W+1];
        for(int i =0; i<t[0].length;i++){
            for(int j =0; j<t.length;j++){
                t[j][i]=-1;
            }
        }
        System.out.println(Solved(wt,val,W,val.length,t));
    }



}