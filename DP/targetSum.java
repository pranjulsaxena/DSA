package DP;

import java.util.Arrays;

public class targetSum {
    // using recursion. time complexity- O(2^N);
    static int Solve(int[]arr,int target){
        return helper(arr,target,arr.length);
    }
    static int helper(int[]arr,int target, int n){
        if(n==0){
            if(target==0){
                return 1;
            }else{
                return 0;
            }
        }
        int include = helper(arr,target-arr[n-1],n-1);
        int exclude = helper(arr,target+arr[n-1],n-1);
        return include + exclude;
    }
    public static void main(String[] args) {
        System.out.println(findTargetSumWays(new int[]{1,1,1,1,1},3));
    }

    // using DP. Time Complexity: O(N*S) , space complexity: O(N*S)
    // approach: previous problem, count the partition whose difference is equal to given difference.
    static int findTargetSumWays(int[]arr, int target){
        int Arrsum=0;
        for(int i=0; i<arr.length;i++){
            Arrsum+=arr[i];
        }
        if((Arrsum+target)%2!=0||(Arrsum+target)<0)return 0; // subset sum can't be fractional and can't be negative
        int sum = (Arrsum + target) / 2;
        int[][]t = new int[arr.length+1][sum+1];
        return totalSubset_Sum(arr,sum,t);
    }
    static int totalSubset_Sum(int []arr,int sum,int [][]t){
        for(int i=0; i<=arr.length;i++){
            for(int j=0; j<=sum;j++){
                if(i==0) {
                    t[i][j] = 0;
                } if(j==0){
                    t[i][j]=1;
                }
            }
        }
        for (int i = 1; i <= arr.length; i++) {
            for (int j = 0; j <= sum; j++) {
                if (arr[i - 1] <= j) {
                    t[i][j] = t[i - 1][j - arr[i - 1]] + t[i - 1][j];
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }
        return t[arr.length][sum];
    }

}
