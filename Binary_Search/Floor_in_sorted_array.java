package Binary_Search;

public class Floor_in_sorted_array {
    public static int findFloor(int[] arr, int x) {
        int start, end, ans,mid;
        start = 0;
        end = arr.length-1;
        ans = -1;
        while(start<=end){
            mid = start + (end-start)/2;
//            if(arr[mid]==x){
//                while(mid<=arr.length-1&&arr[mid]==x){
//                    mid=mid+1;
//                }
//                return mid-1;
//            }
            if(arr[mid]<=x){
                ans = mid;
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(findFloor(new int[]{8, 18, 26, 28, 32, 35, 37, 38, 42, 47, 49, 51, 51, 67, 80},80));
    }
}