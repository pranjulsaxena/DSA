package Backtracking;

public class MaximumSwap {
    static int maximumSwap(int num, int k){
        if(num ==0){
            return 0;
        }
        StringBuilder res = new StringBuilder(String.valueOf(num));
        StringBuilder strr = new StringBuilder(String.valueOf(num));

        helper(strr,0,1,res);
        return Integer.parseInt(res.toString());

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
        System.out.println(maximumSwap(2343,1));
    }
}
