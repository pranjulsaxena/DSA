package Binary_Search;

public class index_first_one_infinite_binary_sorted_array {
    // infinite binary sorted array = 00000000000000011111111111.............
    // approach
    static int search(int[]arr){
        int start = 0;
        int end = 1;
        int key =1;
        while(key>arr[end]){
            start = end;
            end = 2*end;
        }
        // now apply binary search for finding first occurence and here key is 1
        // return BS(arr,start,high,key);
        return -1;
    }
    public static void main(String[] args) {

    }
}
