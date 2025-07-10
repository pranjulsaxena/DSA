import java.util.ArrayList;

public class Josephus_Problem_Circle_of_Death {
    static int solve(int n, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        helper(k - 1, 0, list);
        return list.getFirst();
    }

    static void helper(int k, int index, ArrayList<Integer> list) {
        if (list.size() == 1) return;

        int delete = (index + k) % list.size();
        list.remove(delete);
        helper(k, delete, list); // ✅ Corrected index
    }

    public static void main(String[] args) {
        System.out.println(solve(40, 7)); // Output: 24
    }
}
