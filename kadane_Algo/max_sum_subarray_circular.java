public class max_sum_subarray_circular {
     public static int maxSubarraySumCircular(int[] nums) {
        int maxSumLinear, minSumLinear, maxSumEdges, sum;
        maxSumLinear = MaxSum(nums);
        minSumLinear = MinSum(nums);
        sum =0;
        for(int i:nums){
            sum+=i;
        }
        if(minSumLinear == sum){ // it means all all elements are negative.
            maxSumEdges = sum;
        }else{
            maxSumEdges = sum-minSumLinear;
        }
        
        return maxSumLinear>=maxSumEdges?maxSumLinear:maxSumEdges;
    }
    public static int MaxSum(int[]nums){
        int ans, bestans;
        ans = nums[0];
        bestans = ans;
        for(int i =1; i<nums.length; i++){
            bestans = Math.max(bestans+nums[i],nums[i]);
            ans = Math.max(ans,bestans);
        }
        return ans;
    }
    public static int MinSum(int[]nums){
         int ans, bestans;
        ans = nums[0];
        bestans = ans;
        for(int i =1; i<nums.length; i++){
            bestans = Math.min(bestans+nums[i],nums[i]);
            ans = Math.min(ans,bestans);
        }
        return ans;
    }


    // more optimised code
    public static int maxSubarraySumCircular2(int[] nums) {
        int totalSum = 0;
        int currMax = 0, globalMax = nums[0];
        int currMin = 0, globalMin = nums[0];

        for (int x : nums) {
            // 1. Calculate Standard Kadane's (Max Subarray)
            currMax = Math.max(x, currMax + x);
            globalMax = Math.max(globalMax, currMax);

            // 2. Calculate Inverse Kadane's (Min Subarray)
            currMin = Math.min(x, currMin + x);
            globalMin = Math.min(globalMin, currMin);

            // 3. Calculate Total Sum
            totalSum += x;
        }

        // Edge Case: If all numbers are negative
        // In this case, globalMax will be the largest negative number (e.g., -1)
        // while (totalSum - globalMin) would be 0 (empty array logic), which is wrong.
        if (globalMax < 0) {
            return globalMax;
        }

        // Return the max of Linear Case vs Circular Case
        return Math.max(globalMax, totalSum - globalMin);
    }
    public static void main(String[] args) {
        System.out.println(maxSubarraySumCircular2(new int[]{-3,-2,-3}));
    }
}