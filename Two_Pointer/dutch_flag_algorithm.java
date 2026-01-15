package Two_Pointer;

import java.util.Arrays;

public class dutch_flag_algorithm {
    static void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                int a = nums[low];
                int b = nums[mid];
                nums[low] = b;
                nums[mid] = a;
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                int a = nums[mid];
                int b = nums[high];
                nums[mid] = b;
                nums[high] = a;
                high--;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 2, 0, 0, 1, 2, 0, 1};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
