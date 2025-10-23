package DP;

import java.util.Arrays;
import java.util.HashMap;
// gfg
public class boolean_parenthesization_problem {
    static boolean evaluate(boolean b1, boolean b2, char op)
    {
        if (op == '&') {
            return b1 & b2;
        }
        else if (op == '|') {
            return b1 | b2;
        }
        return b1 ^ b2;
    }

    static int countRecur(int i, int j, boolean req, String s)
    {

        if (i == j) {
            return (req == (s.charAt(i) == 'T')) ? 1 : 0;
        }

        int ans = 0;
        for (int k = i + 1; k < j; k += 2) {

            int leftTrue = countRecur(i, k - 1, true, s);
            int leftFalse = countRecur(i, k - 1, false, s);

            int rightTrue = countRecur(k + 1, j, true, s);
            int rightFalse = countRecur(k + 1, j, false, s);

            if (evaluate(true, true, s.charAt(k)) == req) {
                ans += leftTrue * rightTrue;
            }
            if (evaluate(true, false, s.charAt(k)) == req) {
                ans += leftTrue * rightFalse;
            }
            if (evaluate(false, true, s.charAt(k)) == req) {
                ans += leftFalse * rightTrue;
            }
            if (evaluate(false, false, s.charAt(k))
                    == req) {
                ans += leftFalse * rightFalse;
            }
        }

        return ans;
    }
    static boolean evaluate(int b1, int b2, char op)
    {
        if (op == '&') {
            return (b1 & b2) == 1;
        }
        else if (op == '|') {
            return (b1 | b2) == 1;
        }
        return (b1 ^ b2) == 1;
    }

    static int countRecur(int i, int j, int req, String s,int[][][] memo)
    {

        if (i == j) {
            return (req == (s.charAt(i) == 'T' ? 1 : 0)) ? 1: 0;
        }

        if (memo[i][j][req] != -1) {
            return memo[i][j][req];
        }

        int ans = 0;
        for (int k = i + 1; k < j; k += 2) {

            int leftTrue = countRecur(i, k - 1, 1, s, memo);
            int leftFalse
                    = countRecur(i, k - 1, 0, s, memo);

            int rightTrue
                    = countRecur(k + 1, j, 1, s, memo);
            int rightFalse
                    = countRecur(k + 1, j, 0, s, memo);

            if (evaluate(1, 1, s.charAt(k)) == (req == 1)) {
                ans += leftTrue * rightTrue;
            }
            if (evaluate(1, 0, s.charAt(k)) == (req == 1)) {
                ans += leftTrue * rightFalse;
            }
            if (evaluate(0, 1, s.charAt(k)) == (req == 1)) {
                ans += leftFalse * rightTrue;
            }
            if (evaluate(0, 0, s.charAt(k)) == (req == 1)) {
                ans += leftFalse * rightFalse;
            }
        }

        return memo[i][j][req] = ans;
    }

    // memoization using hashmap . key is made using changing parameters i.e i+j+req .
    static int countRecur(int i, int j, boolean req, String s, HashMap<String,Integer> memo)
    {
        if(memo.containsKey(i+"_"+j+"_"+req)){
            return memo.get(i+"_"+j+"_"+req);
        }
        if (i == j) {
            return (req == (s.charAt(i) == 'T')) ? 1 : 0;
        }
        int ans = 0;
        for (int k = i + 1; k < j; k += 2) {

            int leftTrue = countRecur(i, k - 1, true, s);
            int leftFalse = countRecur(i, k - 1, false, s);

            int rightTrue = countRecur(k + 1, j, true, s);
            int rightFalse = countRecur(k + 1, j, false, s);

            if (evaluate(true, true, s.charAt(k)) == req) {
                ans += leftTrue * rightTrue;
            }
            if (evaluate(true, false, s.charAt(k)) == req) {
                ans += leftTrue * rightFalse;
            }
            if (evaluate(false, true, s.charAt(k)) == req) {
                ans += leftFalse * rightTrue;
            }
            if (evaluate(false, false, s.charAt(k))
                    == req) {
                ans += leftFalse * rightFalse;
            }
        }

         memo.put(i+"_"+j+"_"+req,ans);
        return ans;
    }
    static int countWays(String s)
    {

        int n = s.length();
//        return countRecur(0, n - 1, true, s);
        int[][][] memo = new int[n][n][2];
        for (int[][] mat : memo) {
            for (int[] row : mat) {
                Arrays.fill(row, -1);
            }
        }
//        return countRecur(0, n - 1, 1, s, memo);
        HashMap<String,Integer> dp = new HashMap<>();
        return countRecur(0,n-1,true,s,dp);
    }

    public static void main(String[] args)
    {
        String s = "T|T&F^T";
        System.out.println(countWays(s));
    }
}
