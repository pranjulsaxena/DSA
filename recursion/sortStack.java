import java.util.Stack;

public class sortStack {
    static void sort(Stack<Integer> stack){
        if(stack.size()==1){
            return;
        }
        int temp = stack.pop();
        sort(stack);
        insert(stack,temp);
    }
    static void insert(Stack<Integer> stack, int temp){
        if(stack.isEmpty() || stack.peek()>temp){
            stack.push(temp);
            return;
        }
        int value = stack.pop();
        insert(stack,temp);
        stack.push(value);
    }
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(2);
        stack.push(0);
        stack.push(3);
        stack.push(9);
        stack.push(8);
        stack.push(1);

        sort(stack);

        System.out.println("Sorted Stack in Decreasing Order " + stack);
    }
}
