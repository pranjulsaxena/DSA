package Binary_Search;

import java.util.ArrayList;

public class First_and_last_occurence {
    static ArrayList<Integer> find(int arr[], int x) {
        int start, end, mid, first, last;
        ArrayList<Integer> ans = new ArrayList<>();
        start = 0;
        end = arr.length - 1;
        first = -1;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (arr[mid] == x) {
                first = mid;
                end = mid - 1;
            } else if (arr[mid] > x) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        start = 0;
        end = arr.length - 1;
        last = -1;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (arr[mid] == x) {
                last = mid;
                start = mid + 1;
            } else if (arr[mid] > x) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        ans.add(first);
        ans.add(last);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(find(new int[]{1, 3, 4, 5, 5, 5, 5, 5, 5, 67, 123, 125}, 671));
    }
}
