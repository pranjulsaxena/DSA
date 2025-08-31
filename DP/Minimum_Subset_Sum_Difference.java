package DP;

import java.util.ArrayList;

public class Minimum_Subset_Sum_Difference {
    // exponential time complexity O(2^N) .. not optimal for large input.. will display run time errors;
    public static int minDifference_recursion(int[]arr){
        int sum=0;
        for(int i =0; i<arr.length;i++){
            sum+=arr[i];
        }
        return helper_recursion(arr,0,arr.length,sum);
    }
    private static int helper_recursion(int[]array,int sumCalculated, int n,int totalSum){
        if(n==0||sumCalculated>(totalSum/2)){
            return Math.abs(totalSum-(2*sumCalculated));
        }
        return Math.min(helper_recursion(array,sumCalculated+array[n-1],n-1,totalSum),helper_recursion(array,sumCalculated,n-1,totalSum));
    }
    // using tabulation method (bottom-up approach) dp
    public static int minDifference(int []arr) {
        int sum=0;
        for (int j : arr) {
            sum += j;
        }
        ArrayList<Integer> subsetSums = new ArrayList<>();
        boolean [][]t = new boolean[arr.length+1][sum+1];
        return helper(arr,sum,subsetSums,t);
    }
    private static int helper(int[]arr,int sum,ArrayList<Integer> list,boolean[][]t){
        for(int i=0; i<=arr.length;i++){
            for(int j=0; j<=sum;j++){
                if(i==0) {
                    t[i][j] = false;
                } if(j==0){
                    t[i][j]=true;
                }
            }
        }
        for (int i = 1; i <= arr.length; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] <= j) {
                    t[i][j] = t[i - 1][j - arr[i - 1]] || t[i - 1][j];
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }

        for(int i =0; i<=(sum/2);i++){
            if(t[arr.length][i]){
                list.add(i);
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i=0; i<list.size();i++){
            int ans = Math.abs(sum-(2*list.get(i))); // ans = (
            min = Math.min(min,ans);
        }
        return min;
    }
    public static void main(String[] args) {
        System.out.println(minDifference(new int[]{1,6,5,11}));
    }
}
