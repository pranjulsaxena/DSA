package Binary_Search;

public class search_in_nearly_sroted_array {
    public static int findTarget(int arr[], int target) {
        int start,end,mid;
        start = 0;
        end = arr.length-1;
        while(start<=end){
            mid = start +(end-start)/2;
            if(arr[mid]>target){
                if(mid<arr.length-1&&arr[mid+1]==target){
                    return mid+1;
                }
                end = mid-1;
            }else if(arr[mid]<target){
                if (mid > 0 && arr[mid-1] == target) {
                    return mid - 1;
                }
                start = mid + 1;
            }else{
                return mid;
            }
        }
        return -1;

    }

    // more optimised approach
    public static int find(int[]arr, int target){
        int start, mid, end;
        start =0;
        end = arr.length-1;
        while(start<=end){
            mid=start+(end-start)/2;
            if(arr[mid]==target){
                return mid;
            }else if(mid<arr.length-1&&arr[mid+1]==target){
                return mid+1;
            }else if(mid>0&&arr[mid-1]==target){
                return mid-1;
            }else if(arr[mid]<target){
                start =  mid+2;
            }else{
                end = mid-2;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(find(new int[]{10, 20, 30},15));
    }
}
