package DP;

public class partition_equal_subset_DP {
    static boolean canPartitionDP(int[]nums){
        int sum=0;
        for (int num : nums) {
            sum += num;
        }
        if(sum%2!=0){
            return false;
        }
        boolean[][] t = new boolean[nums.length+1][(sum/2)+1];
        return canPartition_helper(nums,t,sum/2);
    }
    static boolean canPartition_helper(int[]nums,boolean[][]t,int sum){
        for(int i=0;i<=nums.length;i++){
            for(int j =0;j<=sum;j++){
                if(i==0) {
                    t[i][j] = false;
                } if(j==0){
                    t[i][j]=true;
                }
            }
        }
        for(int i=1;i<=nums.length;i++){
            for(int j=1;j<=sum;j++){
                if(nums[i-1]<=j){
                    t[i][j]=t[i-1][j-nums[i-1]]||t[i-1][j];
                }else{
                    t[i][j]=t[i-1][j];
                }
            }
        }
        return t[nums.length][sum];
    }
    public static void main(String[] args) {
//        System.out.println(canPartitionDP(new int[]{1,5,5,11}));
        System.out.println(canPartitionDP(new int[]{100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,99,97}));
    }
}
