package DP;
// variation of knapsack01 problem
public class Subset_Sum_DP {
    static Boolean isSubsetSum(int []arr,int sum){
        return helper(arr,sum,arr.length);
    }
    static boolean helper(int []array,int sum,int n){
        if(sum==0){
            return true;
        }
        if(n==0||sum<0){
            return false;
        }

        if(array[n-1]<=sum){
            return helper(array,sum-array[n-1],n-1)||helper(array,sum,n-1);
        }else{
           return helper(array,sum,n-1);
        }
    }
    // DP using
    static Boolean isSubsetSum_DP(int []arr,int sum,boolean [][]t){
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
        return t[arr.length][sum];
    }
    public static void main(String[] args) {
//        boolean answer = isSubsetSum(new int[]{10, 20, 30, 40, 50, 15, 25, 35, 45, 55, 60, 70, 80, 90, 100, 12, 22, 32, 42, 52, 62, 72, 82, 92, 18, 28, 38, 48, 58, 68, 78, 88, 98, 14, 24, 34, 44, 54, 64, 74, 84, 94, 16, 26, 36, 46, 56, 66, 76, 86, 96, 11, 21, 31, 41, 51, 61, 71, 81, 91, 13, 23, 33, 43, 53, 63, 73, 83, 93, 17, 27, 37, 47, 57, 67, 77, 87, 97, 19, 29, 39, 49, 59, 69, 79, 89, 99, 100, 90, 80, 70, 60, 50, 40, 30, 20, 10, 15, 25, 35, 45, 55, 65, 75, 85, 95, 12, 22, 32, 42, 52, 62, 72, 82, 92, 18, 28, 38, 48, 58, 68, 78, 88, 98, 14, 24, 34, 44, 54, 64, 74, 84, 94, 16, 26, 36, 46, 56, 66, 76, 86, 96},4969);
//        boolean answer =isSubsetSum(new int[]},83);
//        int []array = {10, 20, 30, 40, 50, 15, 25, 35, 45, 55, 60, 70, 80, 90, 100, 12, 22, 32, 42, 52, 62, 72, 82, 92, 18, 28, 38, 48, 58, 68, 78, 88, 98, 14, 24, 34, 44, 54, 64, 74, 84, 94, 16, 26, 36, 46, 56, 66, 76, 86, 96, 11, 21, 31, 41, 51, 61, 71, 81, 91, 13, 23, 33, 43, 53, 63, 73, 83, 93, 17, 27, 37, 47, 57, 67, 77, 87, 97, 19, 29, 39, 49, 59, 69, 79, 89, 99, 100, 90, 80, 70, 60, 50, 40, 30, 20, 10, 15, 25, 35, 45, 55, 65, 75, 85, 95, 12, 22, 32, 42, 52, 62, 72, 82, 92, 18, 28, 38, 48, 58, 68, 78, 88, 98, 14, 24, 34, 44, 54, 64, 74, 84, 94, 16, 26, 36, 46, 56, 66, 76, 86, 96};
//            int []array={7,4,5};
        int []array = {11,48,53};
//        System.out.println(answer);
        int sum = 112;
        boolean[][] matrix = new boolean[array.length+1][sum+1];
        System.out.println(isSubsetSum_DP(array,sum,matrix));
    }
}
