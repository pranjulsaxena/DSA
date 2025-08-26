package DP;

public class count_of_subset_with_given_sum {
    // using recursion .. not working for large input.
    static int totalSubset_Sum(int []arr,int sum){
         return helper(arr,sum,arr.length);

    }
    static int helper(int []array,int sum,int n){
        if(sum==0){
            return 1;
        }
        if(n==0||sum<0){
           return 0;
        }
             return helper(array,sum-array[n-1],n-1)+helper(array,sum,n-1);

    }
    // using DP (top-down approach)
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
        int sum = 24;
        int []array = {28, 4, 3, 27, 0, 24, 26};
        int[][] matrix = new int[array.length+1][sum+1];
        System.out.println(totalSubset_Sum(array,sum));
//        System.out.println(totalSubset_Sum(array,sum,matrix));

    }
}

