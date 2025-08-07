package Backtracking;

//public class Permutation_in_string_backtracking {
//    static void permutation(StringBuilder str){
//        if(str.isEmpty()){
//            return;
//        }
//        helper(str,0);
//    }
//    static void helper(StringBuilder str,int index){
//    if(index == str.length()){
//        System.out.println(str);
//        return;
//    }
//
//       for(int j = index; j<str.length(); j++){
//           char a = str.charAt(index);
//           char b = str.charAt((index+j)-index);
//           str.setCharAt(index,b);
//           str.setCharAt((index+j)-index,a);
//           helper(str,index+1);
//
//       }
//    }
//    public static void main(String[] args) {
//        StringBuilder str = new StringBuilder("abc");
//        permutation(str);
//    }
//}

// there is a big bug in above code.. i.e. no backtract ( rever change) as it is pass by refernce that modification is as

import java.sql.Array;
import java.util.ArrayList;

public class Permutation_in_string_backtracking {
    static void permutation(StringBuilder str){
        if(str.isEmpty()){
            return;
        }
        helper(str,0);
    }
    static void helper(StringBuilder str,int index){
        if(index == str.length()){
            System.out.println(str);
            return;
        }
        ArrayList<Character> list = new ArrayList<>();
        for(int j = index; j<str.length(); j++){
            if(!list.contains(str.charAt(j))){
                list.add(str.charAt(j));
                // swap
                swap(str,index,j);
                helper(str,index+1);
                //Backtrack (revert changes)
                swap(str,index,j);
            }
        }
    }
    static void swap(StringBuilder str, int index, int j){
        char temp = str.charAt(index);
        str.setCharAt(index,str.charAt(j));
        str.setCharAt(j,temp);
    }
    public static void main(String[] args) {
        StringBuilder str = new StringBuilder("aba");
        permutation(str);
    }
}

