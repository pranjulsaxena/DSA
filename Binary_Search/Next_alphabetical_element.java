package Binary_Search;

public class Next_alphabetical_element {
    public static  char nextGreatestLetter(char[] letters, char target) {
        int start,end,mid;
        char ans = letters[0];
        start = 0;
        end = letters.length-1;
        while(start<=end){
            mid = start + (end-start)/2;
            if(letters[mid]>target){
                ans = letters[mid];
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(nextGreatestLetter(new char[]{'c','c','j'},'c'));
    }
}
