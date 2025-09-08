package DP;
// unbounded knapsack -- variation

public class rod_cutting_problem {
    // using recursive .
    // time complexity: O(n^n) , space complexity: O(n)
    static int cutRod1(int[] price) {
        int n = price.length;
        return helper_recur(n, price);
    }
    static int helper_recur(int i, int[] price) {

        if (i == 0) return 0;
        int ans = 0;

        for (int j = 1; j <= i; j++) {
            ans = Math.max(ans, price[j - 1] + helper_recur(i - j, price));
        }
        return ans;
    }
        // using dp (variation of unbounded knapsack)
        static int cutRod(int[]price){
            int[]length = new int[price.length];
            for(int i =0; i<length.length;i++){
                length[i]=i+1;
            }
            int n = length.length;
            int[][] dp = new int[price.length + 1][n + 1];
            return  Solve2(price,length,n,dp);

        }
        static int Solve2(int[]price,int[]length,int n,int[][]dp){
            for (int i = 0; i < price.length + 1; i++) {
                for (int j = 0; j < n + 1; j++) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 0;
                    }
                }
            }
            for (int i = 1; i < price.length + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    if (length[i - 1] <= j) {

                        dp[i][j] = Math.max(price[i - 1] + dp[i][j - length[i - 1]], dp[i - 1][j]);
                    } else {

                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
            return dp[price.length][n];
        }

        public static void main(String[] args) {

            int[] price = new int[1000];
            for (int i = 0; i < 1000; i++) {
                price[i] = 1000000 - i;
            }
            System.out.println(cutRod(price));


        }

}
