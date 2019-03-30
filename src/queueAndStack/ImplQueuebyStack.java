package queueAndStack;

import java.util.Stack;

public class ImplQueuebyStack {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push(int node){
        stack1.push(node);
    }

    public int pop() {

        while (!stack1.empty()){
            stack2.push(stack1.pop());
        }
        int val = stack2.pop();
        while (!stack2.empty()){
            stack1.push(stack2.pop());
        }

        return val;
    };

    public static void main(String[] args) {
        ImplQueuebyStack queue = new ImplQueuebyStack();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.pop());
    }
}
