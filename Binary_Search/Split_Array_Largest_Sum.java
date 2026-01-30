package Binary_Search;

public class Split_Array_Largest_Sum {
    public static int splitArray(int[] nums, int k) {
        int start,end,mid,res;
        start = max(nums);
        end = sum(nums);
         res = -1;
        while(start<=end){
            mid = start + (end-start)/2;
            if(isValid(nums,mid,k)){
                res = mid;
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return res;
    }
    public static int max(int[]nums){
        int max = Integer.MIN_VALUE;
        for(int i:nums){
            if(i>=max){
                max = i;
            }
        }
        return max;
    }
    public static int sum(int[]nums){
        int sum =0;
        for(int i:nums){
            sum+=i;
        }
        return sum;
    }
    public static boolean isValid(int[]nums,int min,int k){
        int sum,student;
        sum =0;
        student = 1;
        for(int i =0; i<nums.length; i++){
            sum +=nums[i];
            if(sum>min){
                student++;
                sum = nums[i];
                if(student>k){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(splitArray(new int[]{1,2,3,4,5},2));
    }
}
