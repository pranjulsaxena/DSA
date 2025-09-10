package DP;

import java.net.Inet4Address;
import java.util.ArrayList;

public class coin_change_minimum_no_coins {
    // recursive approach . Time complexity- O(2^N). space Complexity: O(N)
    static int minCoins(int[]coins,int sum){
        ArrayList<Integer> list = new ArrayList<>();
         helper(coins,sum,coins.length,0,list);
         int min=Integer.MAX_VALUE;
        if(list.isEmpty()){
            min=-1;
        }else{
            for(int i =0; i<list.size();i++){
                min=Math.min(min,list.get(i));
            }
        }
     return min;
    }
    static void helper(int[]coins, int amount, int n, int index, ArrayList<Integer> list){
        if(amount==0){
            list.add(index);
            return;
        }
        if(amount<0 || n<=0){
            return ;
        }
        if(coins[n-1]<=amount){
           helper(coins,amount-coins[n-1],n,index+1,list);  helper(coins,amount,n-1,index,list);
        }else{
             helper(coins,amount,n-1,index,list);
        }

    }
    public static void main(String[] args) {
        System.out.println(minCoins(new int[]{4, 6, 2},5));
    }
}
