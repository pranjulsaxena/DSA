package Two_Pointer;

import java.util.Arrays;

public class three_sum_smaller {
    static long countTriplets(int n, int sum, long arr[]) {
        Arrays.sort(arr);
        long count =0;
        for(int i =0; i<n-2; i++){
            int left = i+1;
            int right = n-1;
            while(left<right){
                int newSum = (int)(arr[i] + arr[left] + arr[right]);
                if(newSum<sum){
                    count += right -left;
                    left++;
                }else{
                    right--;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        long []array = {-2,0,1,3};
        System.out.println(countTriplets(4,2,array));
    }
}
