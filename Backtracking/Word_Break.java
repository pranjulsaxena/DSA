package Backtracking;

import java.util.ArrayList;
import java.util.List;

//public class Word_Break {
//    static List<String> wordBreak(String s, List<String> wordDict){
//        List<String> list = new ArrayList<>();
//        if(s.isEmpty() || wordDict.isEmpty()){
//            return list;
//        }
//        helper(s,0,"",wordDict, list);
//        return list;
//    }
//    static void helper(String str,int index, String currString,List<String> wordDict, List<String> list){
//        if(index==str.length()){
//            list.add(currString.trim());
//            return;
//        }
//        for(int i = index; i<str.length(); i++){
//            String inDict = str.substring(index,i+1);
//            if(isinDict(wordDict,inDict)){
////                currString=currString+inDict+",";
////                helper(str,i+1,currString,dict);
//                helper(str,i+1,currString+inDict+" ",wordDict,list);
//            }
//        }
//    }
//    static boolean isinDict(List<String> dict, String inDict){
//        for(int i =0; i<dict.size(); i++){
//            if(dict.get(i).equals(inDict)){
//                return true;
//            }
//        }
//        return false;
//    }
//    public static void main(String[] args) {
//        String s = "catsanddog";
//        List<String> wordDict = new ArrayList<>();
//        String[] array={"cat","cats","and","sand","dog"};
//        for(int i=0; i<array.length; i++){
//            wordDict.add(array[i]);
//        }
//        System.out.println( wordBreak(s,wordDict));
//    }
//}


// Using backtracking ----> preferred approach


public class Word_Break {
    static List<String> wordBreak(String s, List<String> wordDict){
        List<String> list = new ArrayList<>();
        if(s.isEmpty() || wordDict.isEmpty()){
            return list;
        }
        StringBuilder currString = new StringBuilder();
        helper(s,0,wordDict, list,currString);
        return list;
    }
    static void helper(String str,int index,List<String> wordDict, List<String> list,StringBuilder currString){
        if(index==str.length()){
            list.add(currString.toString().trim());
            return;
        }
        for(int i = index; i<str.length(); i++){
            String inDict = str.substring(index,i+1);
            int length = currString.length();
            if(isinDict(wordDict,inDict)){
                currString.append(inDict+" ");
                helper(str,i+1,wordDict,list,currString);
                // backtrack
                currString.setLength(length);
            }
        }
    }
    static boolean isinDict(List<String> dict, String inDict){
        for(int i =0; i<dict.size(); i++){
            if(dict.get(i).equals(inDict)){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        String s = "pineapplepenapple";
        List<String> wordDict = new ArrayList<>();
        String[] array={"apple","pen","applepen","pine","pineapple"};
        for(int i=0; i<array.length; i++){
            wordDict.add(array[i]);
        }
        System.out.println( wordBreak(s,wordDict));
    }
}







