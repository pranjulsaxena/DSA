package Backtracking;

import java.util.ArrayList;

// gfg

//public class N_digits_numbers_with_increasing_order {
//
//    public static ArrayList<Integer> increasingNumbers(int n){
//        if(n==0){
//            ArrayList<Integer> list = new ArrayList<Integer>(0);
//            return list;
//        }
//        ArrayList<Integer> list = new ArrayList<>();
//        helper(n,0,"",list);
//        return list;
//    }
//
//    static void helper(int n,int index,String curr,ArrayList<Integer> list){
//        if(index ==n) {
//            list.add(Integer.parseInt(curr));
//            return;
//        }
//
//        if(curr ==""){
//            if(n==1) {
//                for(int i = 0; i<10; i++){
//                    String str = curr+i;
//                    helper(n,index+1,str,list);
//                }
//            }else{
//                for(int i = index+1; i<10; i++){
//                    String str = curr+i;
//                    helper(n,index+1,str,list);
//                }
//            }
//
//        }else{
//            char a = curr.charAt(curr.length()-1);
//            for(int i = Character.getNumericValue(a)+1;i<10; i++ ){
//                String str = curr+i;
//                helper(n,index+1,str,list);
//            }
//        }
//
//    }
//    public static void main(String[] args) {
//        System.out.println(increasingNumbers(2));
//    }
//}


// clean code .... logic is same in both codes
public class N_digits_numbers_with_increasing_order {
    static ArrayList<Integer> increasingNumbers(int n){
        ArrayList<Integer> list = new ArrayList<>();
        if(n==0){
            return list;
        }
        solve(n,0,0,list);
        return list;
    }
    static void solve(int n,int index, int res,ArrayList<Integer> list){
        // Base case
        if(index == n){
            list.add(res);
            return;
        }
        // controller recursion
        if(n ==1){
            for(int i = 0; i<=9; i++){
                solve(n,index+1,res*10+i,list);
            }
        }
        else{
            for(int i = (res%10)+1; i<=9; i++){
                solve(n,index+1,res*10+i,list);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(increasingNumbers(1));
    }
}


// time complexity: O(9^n)
// space complexith: O(n)

// this problem is solved only recursion that's why there is no backtrack . Backtracking will be required if res is passed as reference(StringBuilder)