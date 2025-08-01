import java.util.ArrayList;

//public class permutation_in_space {
//    static void function(String str, String curr, int index) {
//        if (index == str.length()) {
//            System.out.println(curr);
//            return;
//        }
//
//        function(str, curr + str.charAt(index), index + 1);
//        function(str, curr + "_" + str.charAt(index), index + 1);
//
//    }
//
//    public static void main(String[] args) {
//        String str="ABCD";
//        ArrayList<String> list = new ArrayList<String>();
//        list.stream().sorted();
//        String curr= String.valueOf(str.charAt(0));
//        function(str, curr, 1);
//    }
//}

public class permutation_in_space {
    static void permutation(String str){
        if(str.isEmpty()){
            return;
        }
        helper(str,""+str.charAt(0),1);
    }
    static void helper(String str,String current,int index){
        if(index==str.length()){
            System.out.println(current);
            return;
        }
        helper(str,current+str.charAt(index),index+1);
        helper(str,current+"_"+str.charAt(index),index+1);
    }
    public static void main(String[] args) {
        permutation("ABC");
    }
}