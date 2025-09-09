package DP;

public class coin_change {
    static int Solve(int[]coins,int amount){
         return helper(coins,amount,0);
    }
    static int helper(int[]coins,int amount,int index){
        if(amount==0){
            return 1;
        }
        int totalways =0;
        for(int i=index; i<coins.length;i++){
            if(coins[i]<=amount){
                totalways+=helper(coins,amount-coins[i],i);
            }
        }
        return  totalways;
    }
// recursive approach 2
    static int helper3(int[]coins,int amount,int n){
        if(amount==0){
            return 1;
        }
        if(amount<0 || n<=0){
            return 0;
        }
        int ways =0;
        if(coins[n-1]<=amount){
            ways = helper3(coins,amount-coins[n-1],n) + helper3(coins,amount,n-1);
        }else{
            ways = helper3(coins,amount,n-1);
        }
        return ways;
    }


    public static void main(String[] args) {
        System.out.println(Solve2(new int[]{1,2,3},5));
    }
}
