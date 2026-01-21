package Binary_Search;

public class Count_of_an_Element_in_a_Sorted_Array {
   static int countFreq(int[] arr, int target) {
     return lastOccurence(arr,target)-firstOccurence(arr,target)+1;
    }

    static int firstOccurence(int[] arr, int target) {
        int start, end, mid;
        start = 0;
        end = arr.length - 1;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (arr[mid] >= target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }

        }
        return start;
    }
   static int lastOccurence(int[]arr,int target){
        int start, end, mid;
        start = 0;
        end = arr.length - 1;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (arr[mid] <= target) {
                start = mid + 1;
            } else {
                end= mid-1;
            }

        }
        return end;
    }

    public static void main(String[] args) {
        System.out.println(lastOccurence(new int[]{1},-1));
    }
}
