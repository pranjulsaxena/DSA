package Backtracking;

public class Permutation_in_String {
    static void solve(String str){
        if(str.isEmpty()){
            return;
        }
        helper(str,0,"",str.length()-1);
    }
    static void helper(String str,int index, String curr, int i){
        if(str.isEmpty()){
            System.out.println(curr);
            return;
        }
        for(int j = 0; j<str.length(); j++){
            helper(str.substring(0,j)+str.substring(j+1),index,curr+str.charAt(j),0);
        }
    }
    public static void main(String[] args) {
        solve("AbC");
    }
}
