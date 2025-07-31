import java.util.Stack;

public class reverse_stack {

    static void reverse(Stack<Integer> stack) {
        if (stack.size() == 1) {
            return;
        }
        int temp = stack.pop();
        reverse(stack);
        insert(stack, temp);
    }

    static void insert(Stack<Integer> stack, int temp) {
        if (stack.isEmpty()) {
            stack.push(temp);
            return;
        }
        int val = stack.pop();
        insert(stack, temp);
        stack.push(val);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println(stack);

        reverse(stack);
        System.out.println(stack);
    }
}