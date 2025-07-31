import java.util.*;

public class Letter_Case_Permutation {
    static void solve(String str, String curr, int index) {
        if (str.length() == index) {
            System.out.println(curr);
            return;
        }
        char ch = str.charAt(index);
        if (Character.isDigit(ch)) {
            solve(str, curr + ch, index + 1);
        } else {
            char flipped = ' ';
            solve(str, curr + ch, index + 1);
            if (Character.isLowerCase(ch)) {
                flipped = Character.toUpperCase(ch);
            } else {
                flipped = Character.toLowerCase(ch);
            }
            solve(str, curr + flipped, index + 1);
        }
    }
    public static void main(String[] args) {
        solve("a1B2c3", "", 0);
    }
}



