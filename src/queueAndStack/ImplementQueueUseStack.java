package queueAndStack;

import java.util.Stack;

public class ImplementQueueUseStack {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
//        if (stack2.isEmpty())
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }


        return stack2.pop();
    }

    public static void main(String[] args) {
        ImplementQueueUseStack queue = new ImplementQueueUseStack();

        queue.push(1);
        queue.push(2);
        System.out.println(queue.pop());
        queue.push(3);
        System.out.println(queue.pop());
    }
}
