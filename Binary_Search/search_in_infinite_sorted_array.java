package Binary_Search;

public class search_in_infinite_sorted_array {
    static int search(int[]arr,int key){
        int start = 0;
        int end = 1;
        while(key>arr[end]){
            start = end;
            end = 2*end;
        }
        // now apply normally binary search
        // return BS(arr,start,high,key);
        return -1;
    }
    public static void main(String[] args) {

    }
}
