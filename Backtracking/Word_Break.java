package Backtracking;

import java.util.Arrays;

public class Word_Break {
    static void Solve(String str,String []dict){
        if(str.isEmpty() || dict.length==0){
            return ;
        }
        helper(str,0,"",dict);
    }
    static void helper(String str,int index, String currString,String[] dict){
        if(index==str.length()){
            String[]answer=currString.split(",");
            System.out.println(Arrays.toString(answer));
            return;
        }
        for(int i = index; i<str.length(); i++){
            String inDict = str.substring(index,i+1);
            if(isinDict(dict,inDict)){
//                currString=currString+inDict+",";
                helper(str,i+1,currString+inDict+" ",dict);
            }
        }
    }
    static boolean isinDict(String[] dict, String inDict){
        for(int i =0; i<dict.length; i++){
            if(dict[i].equals(inDict)){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        String s = "pineapplepenapple";
        String []dict ={"apple","pen","applepen","pine","pineapple"};
        Solve(s,dict);
    }
}
