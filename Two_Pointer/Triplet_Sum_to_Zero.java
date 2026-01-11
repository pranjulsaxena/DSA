package Two_Pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triplet_Sum_to_Zero {
    private static List<List<Integer>> threeSum(int[]nums){
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i =0; i<nums.length-2; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int left = i+1;
            int right = nums.length-1;
            int target = -nums[i];
            while(left<right){
                int sum = nums[left]+nums[right];
                if(sum==target){
//                    List<Integer> ans = new ArrayList<>();
//                    ans.add(nums[i]);
//                    ans.add(nums[left]);
//                    ans.add(nums[right]);
//                    res.add(ans);
                    res.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    left++;
                    right--;
                        while(left<nums.length&&nums[left]==nums[left-1]){
                            left++;
                        }
                        while(right>=0&&nums[right]==nums[right+1]){
                            right--;
                        }
                }else if(sum>target){
                    right--;
                }else{
                    left++;
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));
    }
}
