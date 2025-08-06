package Backtracking;
import java.util.ArrayList;



public class Largest_in_K_swap {
    static String findMaximumNum(StringBuilder str,int k){
        if(str.isEmpty()){
            return "";
        }
        return helper(str,0,1);
    }
    static String helper(StringBuilder str,int index,int k){
        if(index == k){
            return str.toString();
        }

            ArrayList<Integer> maxx = max(str,index);
           int ch = Character.getNumericValue(str.charAt(index));
            int maxxValue ;
            boolean a = false;


                for (Integer integer : maxx) {
                    maxxValue = Character.getNumericValue(str.charAt(integer));
                    if (maxxValue > ch) {
                        a= true;
                        swap(str, index, integer);
                        helper(str, index + 1, k);
                        swap(str, index, integer);Integer.parseInt(str.toString());
                    }
                }
                if(!a){
                    helper(str,index+1,k);
                }
        return str.toString();
    }
    static ArrayList<Integer> max(StringBuilder str, int index){
        int []array = new int[str.substring(index+1,str.length()).length()];

        StringBuilder newStr = new StringBuilder(str.substring(index+1,str.length()));

        for(int j = 0; j<newStr.length(); j++){
            array[j] = Character.getNumericValue(newStr.charAt(j));
        }
        int maxx = Integer.MIN_VALUE;
        for(int j = 0 ; j<array.length; j++){
            if(array[j]>maxx){
                maxx=array[j];
            }

        }
        ArrayList<Integer> list = new ArrayList<>();

        for(int i =0 ; i<str.length(); i++){
            if(Character.getNumericValue(str.charAt(i))==maxx){
                list.add(i);
            }
        }
        return list;

    }
    static void swap(StringBuilder str,int index,int i){
        char temp = str.charAt(index);
        str.setCharAt(index,str.charAt(i));
        str.setCharAt(i,temp);
    }

    public static void main(String[] args) {
        StringBuilder str = new StringBuilder("1234");
        System.out.println(findMaximumNum(str,2));
    }

}
