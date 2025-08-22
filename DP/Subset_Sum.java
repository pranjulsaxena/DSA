package DP;
// gfg

// using recursion Brute force

//public class Subset_Sum {
//    private static boolean solved = false;
//    static Boolean isSubsetSum(int [] arr, int sum){
//        solved=false;
//        if (arr.length==0){
//            return false;
//        }
//        helper(arr,sum,0,"");
//        return solved;
//    }
//     private static void helper(int []array,int sum,int index,String str){
//        if(index==array.length){
//            int ans=0;
//            for(int i=0; i<str.length();i++){
//                ans+=Character.getNumericValue(str.charAt(i));
//            }
//            if(ans==sum){
//                solved=true;
//               return;
//            }
//            return;
//        }
//        if(solved){
//            return;
//        }
//        helper(array,sum,index+1,str+array[index]);
//        helper(array,sum,index+1,str);
//    }
//    public static void main(String[] args) {
//        boolean answer = isSubsetSum(new int[]{10, 20, 30, 40, 50, 15, 25, 35, 45, 55, 60, 70, 80, 90, 100, 12, 22, 32, 42, 52, 62, 72, 82, 92, 18, 28, 38, 48, 58, 68, 78, 88, 98, 14, 24, 34, 44, 54, 64, 74, 84, 94, 16, 26, 36, 46, 56, 66, 76, 86, 96, 11, 21, 31, 41, 51, 61, 71, 81, 91, 13, 23, 33, 43, 53, 63, 73, 83, 93, 17, 27, 37, 47, 57, 67, 77, 87, 97, 19, 29, 39, 49, 59, 69, 79, 89, 99, 100, 90, 80, 70, 60, 50, 40, 30, 20, 10, 15, 25, 35, 45, 55, 65, 75, 85, 95, 12, 22, 32, 42, 52, 62, 72, 82, 92, 18, 28, 38, 48, 58, 68, 78, 88, 98, 14, 24, 34, 44, 54, 64, 74, 84, 94, 16, 26, 36, 46, 56, 66, 76, 86, 96},5000);
//        System.out.println(answer);
//    }
//}
//
//
//import java.util.ArrayList;
//

    // using backtracking -- brute force (taking long time for bigger input i.e. array of length 200)

//public class Subset_Sum {
//    private static boolean solved = false;
//    static Boolean isSubsetSum(int [] arr, int sum){
//        solved=false;
//        if (arr.length==0){
//            return false;
//        }
//        ArrayList<Integer> list = new ArrayList<>();
//        helper(arr,sum,0,list);
//        return solved;
//    }
//    private static void helper(int []array,int sum,int index,ArrayList<Integer> list){
//        if(index==array.length){
//            int ans=0;

import java.util.ArrayList;

////            for(int i=0; i<str.length();i++){
////                ans+=Character.getNumericValue(str.charAt(i));
////            }
//            for (Integer integer : list) {
//                ans += integer;
//            }
//
//            if(ans==sum){
//                solved=true;
//                return;
//            }
//            return;
//        }
//        if(solved){
//            return;
//        }
//        list.add(array[index]);
//        helper(array,sum,index+1,list);
//        list.removeLast();
//        helper(array,sum,index+1,list);
//    }


    // using recursion-- optimal approach passed all test case.

//    public class Subset_Sum {
//    static boolean isSubsetSum(int[]arr,int sum){
//        return helper(arr,sum,0);
//    }
//    static boolean helper(int[]array,int sum,int index){
//        if(sum==0){
//            return true;
//        }
//        if(sum<0||index==array.length){
//            return false;
//        }
//        return helper(array,sum-array[index],index+1)||helper(array,sum,index+1);
//    }
//    public static void main(String[] args) {
//        boolean answer = isSubsetSum(new int[]{10, 20, 30, 40, 50, 15, 25, 35, 45, 55, 60, 70, 80, 90, 100, 12, 22, 32, 42, 52, 62, 72, 82, 92, 18, 28, 38, 48, 58, 68, 78, 88, 98, 14, 24, 34, 44, 54, 64, 74, 84, 94, 16, 26, 36, 46, 56, 66, 76, 86, 96, 11, 21, 31, 41, 51, 61, 71, 81, 91, 13, 23, 33, 43, 53, 63, 73, 83, 93, 17, 27, 37, 47, 57, 67, 77, 87, 97, 19, 29, 39, 49, 59, 69, 79, 89, 99, 100, 90, 80, 70, 60, 50, 40, 30, 20, 10, 15, 25, 35, 45, 55, 65, 75, 85, 95, 12, 22, 32, 42, 52, 62, 72, 82, 92, 18, 28, 38, 48, 58, 68, 78, 88, 98, 14, 24, 34, 44, 54, 64, 74, 84, 94, 16, 26, 36, 46, 56, 66, 76, 86, 96},5000);
//        System.out.println(answer);
//    }
//
//}

    // using optimal backtracking approach
public class Subset_Sum {
    private static boolean solved = false;

    static Boolean isSubsetSum(int[] arr, int sum) {
        solved = false;

        ArrayList<Integer> list = new ArrayList<>();
        helper(arr, sum, 0, list);
        return solved;
    }

    private static void helper(int[] array, int sum, int index, ArrayList<Integer> list) {
        if (solved) {
            return;
        }
        if (sum == 0) {
            solved = true;
            System.out.println("Subset: "+ list);
            return;
        }
        if (sum < 0 || index == array.length) {
            return;
        }
        list.add(array[index]);
        helper(array, sum - array[index], index + 1, list);
        list.removeLast();
        helper(array, sum, index + 1, list);
    }

    public static void main(String[] args) {
        boolean answer = isSubsetSum(new int[]{10, 20, 30, 40, 50, 15, 25, 35, 45, 55, 60, 70, 80, 90, 100, 12, 22, 32, 42, 52, 62, 72, 82, 92, 18, 28, 38, 48, 58, 68, 78, 88, 98, 14, 24, 34, 44, 54, 64, 74, 84, 94, 16, 26, 36, 46, 56, 66, 76, 86, 96, 11, 21, 31, 41, 51, 61, 71, 81, 91, 13, 23, 33, 43, 53, 63, 73, 83, 93, 17, 27, 37, 47, 57, 67, 77, 87, 97, 19, 29, 39, 49, 59, 69, 79, 89, 99, 100, 90, 80, 70, 60, 50, 40, 30, 20, 10, 15, 25, 35, 45, 55, 65, 75, 85, 95, 12, 22, 32, 42, 52, 62, 72, 82, 92, 18, 28, 38, 48, 58, 68, 78, 88, 98, 14, 24, 34, 44, 54, 64, 74, 84, 94, 16, 26, 36, 46, 56, 66, 76, 86, 96},5000);
        System.out.println(answer);
    }


}