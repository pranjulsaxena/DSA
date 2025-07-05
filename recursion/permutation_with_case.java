public class permutation_with_case {
    static void solve(String str, String curr, int index) {
        if (index == str.length()) {
            System.out.println(curr);
            return;
        }
        char ch = str.charAt(index);

        solve(str, curr + ch, index + 1);

        char flipped;
        if (Character.isUpperCase(ch)) {
            flipped = Character.toLowerCase(ch);
        } else {
            flipped = Character.toUpperCase(ch);
        }
        solve(str, curr + flipped, index + 1);
    }

    public static void main(String[] args) {
        solve("aBc", "", 0);
    }
}