
class max_sum_array {
    public static int maxSubArray(int[] nums) {
        int bestans, ans;
        ans = nums[0];
        bestans = ans;
        int v1, v2;
        for (int i = 1; i < nums.length; i++) {
            v1 = nums[i] + bestans;
            v2 = nums[i];
            bestans = Math.max(v1, v2);
            ans = Math.max(bestans, ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}