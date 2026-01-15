package Sliding_Window;

public class min_sub_array {
    public int minSubArrayLen(int target, int[] nums) {
        int currentSum =0;
        int minWindow = Integer.MAX_VALUE;
        int low =0;
        int high =0;

        while(high<nums.length){
            currentSum+=nums[high];
            high++;

            while(currentSum>=target){
                int currentWindow = high-low;
                minWindow = Math.min(currentWindow,minWindow);
                currentSum-=nums[low];
                low++;
            }
        }
        return minWindow == Integer.MAX_VALUE?0:minWindow;
    }
}
