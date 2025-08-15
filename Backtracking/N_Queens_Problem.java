package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class N_Queens_Problem {
    static List<List<Integer>> NQueen(boolean matrix[][]){
        List<List<Integer>> list = new ArrayList<>();
        if(matrix.length==0){
            return list;
        }
        List<Integer> current = new ArrayList<>();
        helper(matrix,0,list,current);
        return list;
    }
    static void helper(boolean matrix[][],int colm_idx, List<List<Integer>> list,List<Integer>current){
        if(colm_idx==matrix.length){
//            if(current.size()==matrix.length){
//                list.add(current); // this current is stored by reference i.e. during backtracking it will be empty.. thus list will also be empty.[[],[]]
                ArrayList<Integer> newlist = new ArrayList<>(current);
                list.add(newlist);
//            }
            return;
        }
        boolean ans = false;
        for(int row=0; row<matrix.length;row++){
            if(isCheck(row, colm_idx,matrix)){
//                ans = true;
                matrix[row][colm_idx] = true;
                current.add(row+1);
                helper(matrix,colm_idx+1,list,current);
                // backtracking
                matrix[row][colm_idx] = false;
                current.removeLast();
            }
        }
//        if(!ans){
//            helper(matrix,colm_idx+1,list,current);  no need of this: as if there is any column in which queen can't be placed.. then no need to call to another row. because it is required for all queens to placed on each column
//        }
    }
    static boolean isCheck(int row,int col,boolean matrix[][]){
        for(int i=col; i>=0;i--){
            if(matrix[row][i]){
                return false;
            }
        }
        // diag1
        for(int i = row,j=col; i>=0&&j>=0; i--,j--){
            if(matrix[i][j]){
                return false;
            }
        }
        for(int i = row,j=col; i<matrix.length&&j>=0; i++,j--){
            if(matrix[i][j]){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        boolean [][]matrix = {{false,false,false,false},{false,false,false,false},{false,false,false,false},{false,false,false,false}};
        System.out.println(NQueen(matrix));
    }
}
