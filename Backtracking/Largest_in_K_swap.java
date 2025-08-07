package Backtracking;

// gfg

//public class Largest_in_K_swap {
//    static String findMaximumNum(StringBuilder str,int k){
//        if(str.isEmpty()){
//            return "";
//        }
//        return helper(str,0,k);
//    }
//    static String helper(StringBuilder str,int index,int k){
//        if(index == k){
//            return str.toString();
//        }
//
//            ArrayList<Integer> maxx = max(str,index);
//           int ch = Character.getNumericValue(str.charAt(index));
//            int maxxValue ;
//            boolean a = false;
//
//
//                for (Integer integer : maxx) {
//                    maxxValue = Character.getNumericValue(str.charAt(integer));
//                    if (maxxValue > ch) {
//                        a= true;
//                        swap(str, index, integer);
//                        helper(str, index + 1, k);
//
//
//                    }else{
//                        helper(str,index+1,k);
//                    }
//                }
//                if(!a){
//                    helper(str,index+1,k);
//                }
//        return str.toString();
//    }
//    static ArrayList<Integer> max(StringBuilder str, int index){
//        int []array = new int[str.substring(index+1,str.length()).length()];
//
//        StringBuilder newStr = new StringBuilder(str.substring(index+1,str.length()));
//
//        for(int j = 0; j<newStr.length(); j++){
//            array[j] = Character.getNumericValue(newStr.charAt(j));
//        }
//        int maxx = Integer.MIN_VALUE;
//        for(int j = 0 ; j<array.length; j++){
//            if(array[j]>maxx){
//                maxx=array[j];
//            }
//
//        }
//        ArrayList<Integer> list = new ArrayList<>();
//
//        for(int i =index+1 ; i<str.length(); i++){
//            if(Character.getNumericValue(str.charAt(i))==maxx){
//                list.add(i);
//            }
//        }
//        return list;
//
//    }
//    static void swap(StringBuilder str,int index,int i){
//        char temp = str.charAt(index);
//        str.setCharAt(index,str.charAt(i));
//        str.setCharAt(i,temp);
//    }
//
//    public static void main(String[] args) {
//        StringBuilder str = new StringBuilder("42431636");
//        System.out.println(findMaximumNum(str,3));
//    }
//
//}

public class Largest_in_K_swap {
    static String findMaximumNum(String str, int k){
        if(str.isEmpty()){
            return "";
        }
        StringBuilder res = new StringBuilder(str);
        StringBuilder strr = new StringBuilder(str);
        helper(strr,0,k,res);
        return res.toString();

    }
    static void helper(StringBuilder str,int index,int k, StringBuilder response){
        if(index==str.length()||k==0){

            return ;
        }
        boolean a = false;
        char max = max(str,index);
        for(int i = index+1; i<str.length(); i++){

            if(str.charAt(index)<str.charAt(i)&&str.charAt(i)==max){
                a = true;
                // swap
                swap(str,index,i);

                if(str.toString().compareTo(response.toString()) > 0){
                    response.setLength(0);
                    response.append(str.toString());
                }

                helper(str,index+1,k-1,response);
                // backtracking
                swap(str,index,i);
            }
        }
        if(!a){
            helper(str,index+1,k,response);
        }


    }
    static void swap(StringBuilder str,int index,int i){
        char temp = str.charAt(index);
        str.setCharAt(index,str.charAt(i));
        str.setCharAt(i,temp);
    }
    static char max(StringBuilder str,int index){
        char[] array = str.toString().toCharArray();
        char max= ' ';
        for(int i = index+1 ; i<array.length; i++){
            if(array[i]>max){
                max=array[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String demo = "102938475619283746";
        System.out.println(findMaximumNum(demo,3));
    }
}
