package Binary_Search;

public class Rotation_Count_in_Sorted_array {
    public static int findKRotation(int arr[]) {
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
        System.out.println(findKRotation(new int[]{4,5,5,5,6,6,6,7,0,1,2}));
    }
}
