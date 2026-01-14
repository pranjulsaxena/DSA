package Two_Pointer;

import java.util.Arrays;

public class triplet_closet_target {
    public static int threeSumClosest(int[] nums, int target) {
//        int sum =0;
//        int newsum=0;
//        int closestValue =Integer.MAX_VALUE;
//        for(int i=0; i<nums.length-2; i++){
//            for(int j = i+1; j<nums.length-1; j++){
//                for(int k=j+1; k<nums.length; k++){
//                     newsum = nums[i]+nums[j]+nums[k];
//                    int res = Math.abs(target-newsum);
//                    if(closestValue>=res){
//                        closestValue=res;
//                        sum = newsum;
//                    }
//                }
//            }
//        }
//        return sum;

        Arrays.sort(nums);
        int sum =0;
        int newsum =0;
        int closestValue = Integer.MAX_VALUE;
        for(int i =0; i<nums.length-2; i++){
            int left = i+1;
            int right = nums.length-1;
            while(left<right){
                sum = nums[left]+nums[right]+nums[i];
                if(sum == target){
                    return target;
                }
                int res = Math.abs(sum-target);
                if(closestValue>res){
                    closestValue=res;
                    newsum = sum;
                }
                if(sum<target){
                    left++;
                }else{
                    right --;
                }
            }
        }
        return newsum;
    }

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{-1,2,1,-4},1));
    }
}
