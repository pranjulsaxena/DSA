package Binary_Search;

public class ceil_in_sorted_array {
    public static int findCeil(int[] arr, int x) {
        int start, end, ans,mid;
        start = 0;
        end = arr.length-1;
        ans = -1;
        while(start<=end){
            mid = start + (end-start)/2;
            if(arr[mid]>=x){
                ans = mid;
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        System.out.println(findCeil(new int[]{1, 2, 8, 10, 11, 12, 19},0));
    }
}
