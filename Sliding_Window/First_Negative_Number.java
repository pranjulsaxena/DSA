package Sliding_Window;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class First_Negative_Number {
    static List<Integer> firstNegInt(int[] arr, int k) {
        int low = 0;
        int high = 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        LinkedList<Integer> list2 = new LinkedList<>();

        while (high < arr.length) {
            if (arr[high] < 0) {
                list2.add(arr[high]);
            }
            if ((high - low + 1) < k) {
                high++;
            } else if ((high - low + 1) == k) {
                if (list2.isEmpty()) {
                    list.add(0);
                } else {
                    list.add(list2.getFirst());
                    if ( arr[low] == list2.getFirst()) {
                        list2.removeFirst();
                    }
                }
                high++;
                low++;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(firstNegInt(new int[]{-8, 2, 3, -6, 10}, 2));
    }
}
