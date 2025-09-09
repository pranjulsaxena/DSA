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

    // unbounded because a coin can be taken multiple times.
    // using dp unbounded knapsack. variant of count the subsets for given amount problem(subset amount problem)
    // time complexity: O(N*Amount) . Space Complexity: O(N*S)
    static int Solve2(int[]coins,int amount){
        int[][]t = new int[coins.length+1][amount+1];
        return helper2(coins,amount,t,coins.length);
    }
    static int helper2(int[]coins,int amount,int[][]t,int n){
        for(int i=0; i<=n;i++){
            for(int j=0; j<=amount;j++){
                if(i==0){
                    t[i][j]=0;
                }else if(j==0){
                    t[i][j]=1;
                }
            }
        }
        for(int i=1; i<=n;i++){
            for(int j=1; j<=amount; j++){
                if(coins[i-1]<=j){
                    t[i][j]=t[i][j-coins[i-1]]+t[i-1][j];
                }else{
                    t[i][j]=t[i-1][j];
                }
            }
        }
        return t[n][amount];
    }
    public static void main(String[] args) {
        System.out.println(Solve2(new int[]{1,2,3},5));
    }
}
