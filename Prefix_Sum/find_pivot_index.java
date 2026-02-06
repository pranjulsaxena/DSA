public class find_pivot_index {
     public int pivotIndex(int[] nums) {
        if(nums.length==1){
            return 0;
        }
        int leftSum, rightSum,sum;
        sum =0;
        leftSum =0;
        rightSum=0;
        for(int i:nums){
            sum+=i;
        }
        if(leftSum == sum-nums[0]){
            return 0;
        }
        for(int i =1; i<nums.length; i++){
            leftSum+=nums[i-1];
            rightSum = sum-leftSum-nums[i];
            if(leftSum==rightSum){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(new int[]{2,3,4,2,1});
    }
}