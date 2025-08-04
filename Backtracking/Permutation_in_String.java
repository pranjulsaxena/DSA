package Backtracking;

import java.util.ArrayList;

public class Permutation_in_String {
    static void solve(String str){
        if(str.isEmpty()){
            return;
        }
        helper(str,"");
    }
    static void helper(String str, String curr){
        if(str.isEmpty()){
            System.out.println(curr);
            return;
        }
        for(int j = 0; j<str.length(); j++){
                helper(str.substring(0,j)+str.substring(j+1),curr+str.charAt(j));

        }
    }
    public static void main(String[] args) {
        solve("ABA");
    }
}

// controller recursion used in avoid duplicated permutation of string for the duplicate character in input string

public class Permutation_in_String {
    static void solve(String str){
        if(str.isEmpty()){
            return;
        }
        helper(str,"");
    }
    static void helper(String str, String curr){
        if(str.isEmpty()){
            System.out.println(curr);
            return;
        }
        ArrayList<Character> char_list = new ArrayList<>();
        for(int j = 0; j<str.length(); j++){
            // controller recursion
            if(!char_list.contains(str.charAt(j))){
                char_list.add(str.charAt(j));
                helper(str.substring(0,j)+str.substring(j+1),curr+str.charAt(j));
            }
        }
    }
    public static void main(String[] args) {
        solve("ABA");
    }
}