package Binary_Search;

public class Search_a_2D_matrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int i,j;
        i =0;
        j =matrix[i].length-1;
        while(i<matrix.length&&j>=0){
            if(matrix[i][j]==target){
                return true;
            }else if(matrix[i][j]<target){
                i = i+1;
            }else{
                j=j-1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(searchMatrix(new int[][]{{1}},0));
    }
}
