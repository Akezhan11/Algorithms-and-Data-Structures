import java.util.LinkedList;
import java.util.Queue;
//Queue
//Implement a custom Stack data structure using only two Queues.
public class Task4 {

    static class MyStack {
        private Queue<Integer> q1 = new LinkedList<>();
        private Queue<Integer> q2 = new LinkedList<>();
        public void push(int val) {
            q2.offer(val);

            while (!q1.isEmpty()) {
                q2.offer(q1.poll());
            }

            Queue<Integer> temp = q1;
            q1 = q2;
            q2 = temp;
        }
        public int pop() {
            if (isEmpty()) throw new RuntimeException("Stack is empty!");
            return q1.poll();
        }
        public int peek() {
            if (isEmpty()) throw new RuntimeException("Stack is empty!");
            return q1.peek();
        }
        public boolean isEmpty() {
            return q1.isEmpty();
        }
        public int size() {
            return q1.size();
        }
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Peek: " + stack.peek());
        System.out.println("Pop:  " + stack.pop());
        System.out.println("Pop:  " + stack.pop());
        System.out.println("Size: " + stack.size());
        System.out.println("Pop:  " + stack.pop());
        System.out.println("Empty: " + stack.isEmpty());
    }
}