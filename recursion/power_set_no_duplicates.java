import java.util.ArrayList;

public class power_set_no_duplicates {
    static void solve(String str, String curr, int index, ArrayList<String> list) {
        if (index == str.length()){
            if (list.contains(curr)) {
               return;
            } else {
               list.add(curr);
            }
            return;
        }
        solve(str,curr,index+1,list);
        solve(str,curr+str.charAt(index),index+1,list);

    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        solve("aab","",0,list);
        System.out.println(list);
    }
}
