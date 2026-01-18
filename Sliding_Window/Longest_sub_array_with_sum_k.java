package Sliding_Window;

public class Longest_sub_array_with_sum_k {
    public static int longestSubarray(int[]arr,int k){
        int low=0;
        int high =0;
        int sum =0;
        int max = Integer.MIN_VALUE;

        while(high<arr.length ){
            sum+=arr[high];
            if(sum<k){
                high++;
            }else if(sum ==k){
                max = Math.max(max,high-low+1);
                high++;
            }else{
                while(sum>k&&low<=high){
                    sum-=arr[low++];
                    if(sum==k){
                        max = Math.max(max,high-low+1);
                    }
                }
                high++;
            }
        }

        return max==Integer.MIN_VALUE?0:max;
    }

    public static void main(String[] args) {
        System.out.println(longestSubarray(new int[]{10, 5, 2, 7, 1, -10},15));
    }
}
