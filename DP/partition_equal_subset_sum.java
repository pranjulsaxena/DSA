package DP;
// leetcode


import java.util.ArrayList;
import java.util.List;

public class partition_equal_subset_sum {
    // brute force approach: 36 test cases passed . heap memory exceeds as there are 2^n subsets. for input n=100+. memory exceeds
    static boolean canPartition(int[] nums){
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        solve(nums,list,0,list2);
        return find(list,nums.length,nums);
    }
    private static void solve(int[] array,List<List<Integer>> list,int index,List<Integer> list2){
        if(index==array.length){
            ArrayList<Integer> list3 = new ArrayList<>(list2);

            list.add(list3);
            return;
        }

        list2.add(index);
        solve(array,list,index+1,list2);
        list2.removeLast();
        solve(array,list,index+1,list2);
    }
    private static  boolean find(List<List<Integer>> subSets,int n,int[]nums){

        for(int i =0; i<subSets.size();i++){
            for(int j =0; j<subSets.size();j++){
                if((subSets.get(j).size()+subSets.get(i).size())==n&&checkDuplicate(subSets.get(i),subSets.get(j))&&checkSum(subSets.get(i),subSets.get(j),nums)){
                    return true;
                }
            }
        }
        return false;
    }
    private static boolean checkDuplicate(List<Integer> list1, List<Integer> list2){
        for(int i =0; i<list1.size(); i++){
            for(int j=0; j<list2.size();j++){
                if(list1.get(i)==list2.get(j)){
                    return false;
                }
            }
        }
        return true;
    }
    private static boolean checkSum(List<Integer> list1, List<Integer> list2,int[]nums){
        int sum1=0;
        int sum2=0;
        for(int i=0; i<list1.size();i++){
            sum1+=nums[list1.get(i)];
        }
        for(int j=0; j<list2.size();j++){
            sum2+=nums[list2.get(j)];
        }
        if(sum1==sum2){
            return true;
        }
        return false;
    }
    static boolean blocked = false;

    // optimised approach for smaller input . Although there is blocked but still it can take much time from returning.
    static boolean canPartition_OP(int[]nums){
        int sum=0;
        for(int i:nums){
            sum+=i;
        }
        if (sum%2!=0){return false;}
        return helperOP(nums,nums.length,sum/2);
    }
    static boolean helperOP(int[]nums,int n,int sum){
        if(sum==0){
            blocked=true;
            return true;
        }
        if(blocked){
            return true;
        }
        if(sum<0||n==0){
            return false;
        }
        return helperOP(nums,n-1,sum-nums[n-1])||helperOP(nums,n-1,sum);
    }
    public static void main(String[] args) {
//        System.out.println(canPartition_OP(new int[]{1,5,5,11}));
        System.out.println(canPartition_OP(new int[]{100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,99,97}));
    }

}
