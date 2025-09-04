package DP;

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
        System.out.println(Solve(new int[]{1,1,1,1,1},3));
    }

}
