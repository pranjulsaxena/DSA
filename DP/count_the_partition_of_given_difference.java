package DP;

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
    public static void main(String[] args) {
        System.out.println(Solve_Recur(new int[]{1, 2, 3, 1, 2},1));
    }
}
