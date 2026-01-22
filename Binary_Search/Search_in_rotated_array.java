public class Search_in_rotated_array {
    public static int search(int[] nums, int target) {
        int minIndex = minIndex(nums);

        if (minIndex > 0 && target >= nums[0] && target <= nums[minIndex - 1]) {
            return binarySearch(nums, 0, minIndex - 1, target);
        } else {
            return binarySearch(nums, minIndex, nums.length - 1, target);
        }
    }
    public static int binarySearch(int[]nums, int start, int end,int target){
        int mid;
        while(start<=end){
            mid = start + (end-start)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]>target){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return -1;
    }
    public static int minIndex(int arr[]) {
        int start, end, len, mid, next, prev;
        start = 0;
        end = arr.length - 1;
        len = arr.length;
        while (start <= end) {
            if(arr[start]<=arr[end]){
                return start;
            }
            mid = start + (end - start) / 2;
            next = (mid + 1) % len;
            prev = (mid + len - 1) % len;
            if (arr[mid] < arr[next] && arr[mid] < arr[prev]) {
                return mid;
            } else if (arr[start] > arr[mid]) {
                end = mid - 1;
            } else if (arr[mid] > arr[end]) {
                start = mid + 1;
            }

        }
        return 0;

    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{4,5,6,7,0,1,2},1));
    }
}
