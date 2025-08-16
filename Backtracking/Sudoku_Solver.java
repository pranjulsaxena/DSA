package Backtracking;

import java.util.Arrays;

public class Sudoku_Solver {
    static void Solver(char [][]matrix){
        if(matrix.length==0){
            return;
        }
        helper(matrix,0,0);
    }

    static void helper(char [][]matrix,int row,int col_idx){
        if(col_idx == matrix.length){
            for (char[] chars : matrix) {
                System.out.println(Arrays.toString(chars));
            }
            return;
        }

        if(row == matrix.length){
            helper(matrix, 0, col_idx + 1);
            return;
        }

        if(matrix[row][col_idx] == '.') {
            for(int i = 1; i <= 9; i++){
                if(isValid(row, col_idx, i, matrix)){
                    matrix[row][col_idx] = Integer.toString(i).charAt(0);
                    helper(matrix, row + 1, col_idx);
                    matrix[row][col_idx] = '.';
                }
            }
        } else {
            helper(matrix, row + 1, col_idx);
        }
    }

    static boolean isValid(int row,int col_idx,int i,char [][] matrix){
        if(row<0 || row>=matrix.length || col_idx<0 || col_idx>=matrix.length) {
            return false;
        }
        if(matrix[row][col_idx]!='.'){
            return false;
        }
        char val = Integer.toString(i).charAt(0);

        //  column
        for(int r =0; r<matrix.length; r++){
            if(matrix[r][col_idx] == val){
                return false;
            }
        }
        //  row
        for(int c=0; c<matrix.length;c++){
            if(matrix[row][c]== val){
                return false;
            }
        }

        // e subgrid checks
        if(row>=0 && row<=2){
            if(col_idx>=0 && col_idx<=2){
                for(int r=0;r<=2;r++){
                    for(int c=0;c<=2;c++){
                        if(matrix[r][c]==val){
                            return false;
                        }
                    }
                }
            } else if (col_idx>=3&&col_idx<=5) {
                for(int r=0;r<=2;r++){
                    for(int c=3;c<=5;c++){
                        if(matrix[r][c]==val){
                            return false;
                        }
                    }
                }
            } else{
                for(int r=0;r<=2;r++){
                    for(int c=6;c<=8;c++){
                        if(matrix[r][c]==val){
                            return false;
                        }
                    }
                }
            }
        } else if (row>=3 && row<=5) {
            if(col_idx>=0 && col_idx<=2){
                for(int r=3;r<=5;r++){
                    for(int c=0;c<=2;c++){
                        if(matrix[r][c]==val){
                            return false;
                        }
                    }
                }
            }else if (col_idx>=3&&col_idx<=5) {
                for(int r=3;r<=5;r++){
                    for(int c=3;c<=5;c++){
                        if(matrix[r][c]==val){
                            return false;
                        }
                    }
                }
            }else{
                for(int r=3;r<=5;r++){
                    for(int c=6;c<=8;c++){
                        if(matrix[r][c]==val){
                            return false;
                        }
                    }
                }
            }
        }else{
            if(col_idx>=0 && col_idx<=2){
                for(int r=6;r<=8;r++){
                    for(int c=0;c<=2;c++){
                        if(matrix[r][c]==val){
                            return false;
                        }
                    }
                }
            }else if (col_idx>=3&&col_idx<=5) {
                for(int r=6;r<=8;r++){
                    for(int c=3;c<=5;c++){
                        if(matrix[r][c]==val){
                            return false;
                        }
                    }
                }
            }else{
                for(int r=6;r<=8;r++){
                    for(int c=6;c<=8;c++){
                        if(matrix[r][c]==val){
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        Solver(board);
    }
}
