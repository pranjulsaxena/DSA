package DP;
// unbounded knapsack -- variation

public class rod_cutting_problem {
    // using recursive .
    // time complexity: O(n^n) , space complexity: O(n)
    static int cutRod(int[] price) {
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
    public static void main(String[] args) {
        int[] price = {1, 5, 8, 9, 10, 17, 17, 20};
        System.out.println(cutRod(price));
    }
}
