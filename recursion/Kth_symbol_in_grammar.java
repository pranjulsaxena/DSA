public class Kth_symbol_in_grammar {
    static int Solve(int n, int k) {
        if (k == 1 && n == 1) {
            return 0;
        }
        int mid = ((int) Math.pow(2, n - 1)) / 2;
        if (k <= mid) {
            return Solve(n - 1, k);
        } else {
            return Solve(n - 1, k - mid) == 1 ? 0 : 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(Solve(4, 6));
    }
}
