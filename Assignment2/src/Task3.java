import java.util.Stack;

public class Task3 {
    public static Stack<Integer> sortStack(Stack<Integer> stack) {
        Stack<Integer> temp = new Stack<>();
        while (!stack.isEmpty()) {
            int curr = stack.pop();
            while (!temp.isEmpty() && temp.peek() < curr) {
                stack.push(temp.pop());
            }
            temp.push(curr);
        }
        return temp;
    }
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);
        Stack<Integer> sorted = sortStack(stack);
        System.out.println("После: " + sorted);
    }
}