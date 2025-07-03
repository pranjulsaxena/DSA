import java.util.Stack;

public class Delete_middle_element_of_stack {
    static void middle(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int K = (stack.size() / 2) + 1;
        solve(stack, K);
    }

    static void solve(Stack<Integer> stack, int K) {
        if (K <= 1) {
            stack.pop();
            return;
        }
        int temp = stack.pop();
        solve(stack, K - 1);
        stack.push(temp);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 1; i <= 5; i++) {
            stack.push(i);
        }
        System.out.println(stack);
        middle(stack);
        System.out.println(stack);
    }
}