package Two_Pointer;

import java.util.Arrays;

public class Squares_Of_Sorted_Array {
        public static int[] sortedSquares(int[] nums) {
            int n = nums.length;
            int[] res = new int[n];
            int left = 0, right = n - 1;
            int idx = n - 1;

            while (left <= right) {
                int leftSq = nums[left] * nums[left];
                int rightSq = nums[right] * nums[right];

                if (leftSq > rightSq) {
                    res[idx--] = leftSq;
                    left++;
                } else {
                    res[idx--] = rightSq;
                    right--;
                }
            }
            return res;
        }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortedSquares(new int[]{-4, -1, 0, 3, 10})));
    }
}
