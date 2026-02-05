public class max_absolute_sum {
    public static int maxAbsoluteSum(int[] nums) {
        int maxSum, minSum, ans;
        ans = Math.abs(nums[0]);
        maxSum = nums[0];
        minSum = maxSum;

        for(int i =1; i<nums.length; i++){
            maxSum = Math.max(nums[i], maxSum+nums[i]);
            minSum = Math.min(nums[i], minSum+nums[i]);

            ans = Math.max(ans, Math.max(Math.abs(maxSum),Math.abs(minSum)));
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(maxAbsoluteSum(new int[]{2,-5,1,-4,3,-2}));
    }
}