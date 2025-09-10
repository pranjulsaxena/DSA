package DP;
// leetcode: coin change 1
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
    // pattern: similar to previous question. But initialization is different
    // and only question in which there is initialization is at first row.
    // optimal approach. Using Infinite patterns of DP. TC-O(N*Amount) , SC-O(N*Amount)
    static int Solve2(int[]coins,int amount){
        int[][]t = new int[coins.length+1][amount+1];
        int ans= helper2(coins,amount,t,coins.length);
        return ans==Integer.MAX_VALUE?-1:ans;
    }
    static int helper2(int[]coins,int amount,int[][]t,int n){
        for(int i=0; i<=amount; i++){
            t[0][i]= Integer.MAX_VALUE-1;
        }
        for(int i=1; i<=coins.length;i++){
            t[i][0]=0;
        }
        for(int i=1; i<=amount;i++){
            if(i%coins[0]==0){
                t[1][i]=i/coins[0];
            }else{
                t[1][i]= Integer.MAX_VALUE-1;
            }
        }
        for(int i=2; i<=n;i++){
            for(int j=1; j<=amount; j++){
                if(coins[i-1]<=j){
                    t[i][j]=Math.min(t[i][j-coins[i-1]]+1,t[i-1][j]);
                }else{
                    t[i][j]=t[i-1][j];
                }
            }
        }
        return t[n][amount];
    }
    public static void main(String[] args) {
        System.out.println(Solve2(new int[]{4, 6, 2},5));
    }
}
