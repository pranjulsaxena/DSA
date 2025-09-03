package DP;

import java.util.ArrayList;

public class count_the_partition_of_given_difference {
    // time complexity: O(2^n)
    // no optimal for big input. So optimised approach is memoization or tabulation method
    static int Solve_Recur(int[]arr, int diff){
        if(arr.length==0){
            return 0;
        }
        int sum=0;
        for(int i =0; i<arr.length;i++){
            sum+=arr[i];
        }
        return helper_Recur(arr,arr.length,sum,diff,0);
    }
    static int helper_Recur(int[]arr,int n,int totalSum,int diff, int currSum){
        if(currSum>totalSum/2){
            return 0;
        }
        if(n==0) {
            int ans = Math.abs(currSum-(totalSum-currSum));
            if(ans ==diff){
                return 1;
            }else{
                return 0;
            }
        }

        int include = helper_Recur(arr,n-1,totalSum,diff,currSum+arr[n-1]);
        int exclude = helper_Recur(arr,n-1,totalSum,diff,currSum);
        return include+exclude;
    }
    // using approach similar to minimum subset difference (previous question)
    public static int Solve2(int []arr, int d) {
        int sum=0;
        for (int j : arr) {
            sum += j;
        }
        ArrayList<Integer> subsetSums = new ArrayList<>();
        int [][]t = new int[arr.length+1][sum+1];
        return helper(arr,sum,subsetSums,t,d);
    }
    private static int helper(int[] arr, int sum, ArrayList<Integer> list, int[][] t, int diff) {
        for(int i = 0; i <= arr.length; i++){
            for(int j = 0; j <= sum; j++){
                if(i == 0) {
                    t[i][j] = (j == 0) ? 1 : 0;
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

        int count = 0;
        for(int i = 0; i <= sum / 2; i++) {
            if (t[arr.length][i] != 0) {
                int ans = Math.abs(sum - 2 * i);
                if (ans == diff) {
                    count += t[arr.length][i];
                }
            }
        }
        return count;
    }

    // better approach.
    // S1-S2=Diff, S1+S2=Total
    // S1=(Total+Diff)/2; -- then used approach: count the subset whose sum is S1. It will tell how many partition have difference Diff.
    static int Solve3(int[]arr,int diff){
        int Arrsum=0;
        for(int i=0; i<arr.length;i++){
            Arrsum+=arr[i];
        }
        if((Arrsum+diff)%2!=0)return 0; // subset sum can't be fractional.
        int sum = (int)Math.floor((Arrsum + diff) / 2.0);
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
    public static void main(String[] args) {
        System.out.println(Solve2(new int[]{0, 1, 2, 2, 2, 3, 0, 3, 0, 1},12));
    }

}
