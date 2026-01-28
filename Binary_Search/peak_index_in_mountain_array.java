package Binary_Search;

public class peak_index_in_mountain_array {
//    public static int peakIndexInMountainArray(int[] arr) {
//        int start, end, mid;
//        start = 0;
//        end = arr.length - 1;
//        while (start <= end) {
//            mid = start + (end - start) / 2;
//            if (mid == 0 && arr[mid] < arr[mid + 1]) {
//                start = mid + 1;
//            } else if (mid == arr.length - 1 && arr[mid] < arr[mid - 1]) {
//                end = mid - 1;
//            } else if (arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1]) {
//                return mid;
//            } else if (arr[mid] < arr[mid + 1]) {
//                start = mid + 1;
//            } else if (arr[mid] < arr[mid - 1]) {
//                end = mid - 1;
//            }
//
//        }
//        return -1;
//    }
    public static int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;  // Peak is on the right
            } else {
                right = mid;  // Peak is on the left or at mid
            }
        }
        return left;
    }


    public static void main(String[] args) {
        System.out.println(peakIndexInMountainArray(new int[]{3, 5, 3, 2, 0}));
    }
}
