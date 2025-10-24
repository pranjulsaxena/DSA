package DP;
// Leetcode
public class Scramble_String {
        public static boolean isScramble(String s1, String s2) {
            if(s1.length()!=s2.length())return false;
            if(s1.isEmpty() && s2.isEmpty())return true;

            return solve(s1,s2);
        }
        public static boolean solve(String a,String b){
            int n=a.length();
            if(a.equals(b)) return true;

            if(a.length()<1)
            {
                return false;
            }

            boolean flag = false;
            for(int i=1;i<=n-1;i++){
                boolean noswap = solve(a.substring(0,i), b.substring(0,i)) &&
                        solve(a.substring(i), b.substring(i));

                boolean swap = solve(a.substring(0,i), b.substring(n-i)) &&
                        solve(a.substring(i), b.substring(0,n-i));

                if(swap || noswap){
                    flag = true;
                    break;
                }
            }

            return flag;
        }

        public static void main(String[] args) {
            System.out.println(isScramble("abcde","decba"));
        }
}
