package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Palindromic_Partition {
    static List<List<String >> isPalindromicPartition(String str){
        List<List<String>> subStringList = new ArrayList<>();
        if(str.isEmpty()){
            return subStringList;
        }
        StringBuilder strr = new StringBuilder(str);
        ArrayList<String> currString = new ArrayList<>();
        helper( strr, 0,subStringList,currString);
        return subStringList;
    }
    static void helper(StringBuilder str,int index, List<List<String>> subStringList,ArrayList<String> currString){
        if(index == str.length() || str.isEmpty()){
            ArrayList<String> newSubstring = new ArrayList<>(currString);
            subStringList.add(newSubstring);
            return;
        }
        for(int i = 0; i<str.length(); i++){

            String subStr1 = str.substring(0,i+1);
             str = new StringBuilder(str.substring(i));
            if(isPalindrome(subStr1)){
                currString.add(subStr1);
                helper(str,index+1,subStringList,currString);
                // backtrack
                for(int k =0; k<str.length();k++){
                    str.append(str.charAt(k));
                }
                currString.removeLast();
            }
        }
    }
    static boolean isPalindrome(String str){
        int j= str.length()-1;
        for(int i =0; i<str.length()/2; i++){
            if(str.charAt(i)!=str.charAt(j)){
                return false;
            }
            j--;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isPalindromicPartition("aaba"));
    }
}
