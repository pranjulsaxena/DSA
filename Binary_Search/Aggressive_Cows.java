package Binary_Search;

import java.util.Arrays;

public class Aggressive_Cows {
    public static int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);
        int start = 1; int mid;
        int end = stalls[stalls.length-1]-stalls[0];
        int res = 0;

        while(start<=end){
            mid = start + (end-start)/2;
            if(isValid(stalls,k,mid)){
                res = mid;
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return res;
    }
    public static boolean isValid(int[]stalls, int k, int min){
        int cows=1;
        int initial = stalls[0];
        for(int i = 1; i<stalls.length; i++){
            if(stalls[i]-initial>=min){
                cows++;
                initial = stalls[i];
                if(cows==k){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(aggressiveCows(new int[]{2, 12, 11, 3, 26, 7},5));
    }
}
