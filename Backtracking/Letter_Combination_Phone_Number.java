package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Letter_Combination_Phone_Number {
    private static String[] values = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    static List<String> letterCombinations(String digits){
        List<String> list = new ArrayList<>();
        if(digits.isEmpty()){
            return list;
        }
        StringBuilder currString = new StringBuilder();
        helper(digits,0,currString,list);
        return list;
    }
    private static void helper(String str, int index, StringBuilder currString,List<String> list){
        if(index == str.length()){
            list.add(currString.toString());
            return;
        }

        String input = values[Character.getNumericValue(str.charAt(index))-2];
        for(int i =0; i<input.length();i++){
            helper(str,index+1,currString.append(input.charAt(i)),list);
            // backtracking
            currString.deleteCharAt(currString.length()-1);
        }
    }
    public static void main(String[] args) {
        System.out.println(letterCombinations("2"));
    }
}


// time complexity is: O(4^n)
// space complexity is O(n)