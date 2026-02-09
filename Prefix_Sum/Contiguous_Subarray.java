import java.util.HashMap;

public class Contiguous_Subarray {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> diff = new HashMap<>();
        int ones = 0;
        int zeros = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeros++;
            } else {
                ones++;
            }
            int difference = ones - zeros;
            if (difference == 0) {
                ans = Math.max(ans, i + 1);
            } else if (diff.containsKey(difference)) {
                ans = Math.max(i - diff.get(difference), ans);
            } else {
                diff.put(difference, i);
            }

        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
