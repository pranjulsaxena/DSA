public class peak_element {
    public  static int findPeakElement(int[] nums) {
        int start, end , mid;
        start = 0;
        end = nums.length-1;
        if(nums.length==1){
            return 0;
        }
        while(start<=end){
            mid = start + (end-start)/2;
            if(mid>0&&mid<end){
                if(nums[mid]>nums[mid+1]&&nums[mid]>nums[mid-1]){
                    return mid;
                }else if(nums[mid]<nums[mid+1]){
                    start = mid+1;
                }else{
                    end = mid-1;
                }
            }else if(mid == 0){
                if(nums[0]>nums[1]){
                    return 0;
                }else{
                    return 1;
                }
            }else{
                if(nums[end]>nums[end-1]){
                    return end;
                }else{
                    return end-1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findPeakElement(new int[]{1}));
    }
}
