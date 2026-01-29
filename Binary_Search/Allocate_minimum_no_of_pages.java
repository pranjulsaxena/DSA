package Binary_Search;

public class Allocate_minimum_no_of_pages {
    public static int splitArray(int[] nums, int k) {
        int start,end,result,mid;
         start = 0;
         result = -1;
         end = nums.length-1;
        while(start<=end){
            mid = start + (end-start)/2;
            if(isValid(nums, k, mid)){
                result = Math.min(result,mid);
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return result;
    }
    public static boolean isValid(int[]arr,int k,int mid){
        int student =1;
        int sum = 0;
        for(int i=0; i<arr.length;i++){
            sum = sum+arr[i];
            if(sum>mid){
                student++;
                sum = arr[i];
            }
            if(student>k){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(splitArray(new int[]{1,2,3,4,5},2));
    }
}
