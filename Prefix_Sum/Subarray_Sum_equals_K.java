

import java.util.HashMap;

public class Subarray_Sum_equals_K {

    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> PrefixSum = new HashMap<>();
        PrefixSum.put(0, 1);
        int sum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (PrefixSum.containsKey(sum - k)) {
                count += PrefixSum.get(sum - k);
            }
            PrefixSum.put(sum, PrefixSum.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[] { 1, 2, 3 }, 3));
    }
}