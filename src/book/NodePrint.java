package book;

import java.util.Stack;

public class NodePrint {

    // 非递归 先序遍历
    public static void preOrderUnRecur(Node head){
        System.out.print("pre-order: ");
        if (head != null){
            Stack<Node> stack = new Stack<>();
            stack.add(head);
            while (!stack.isEmpty()){
                Node t = stack.pop();
                System.out.print(t.value + " ");
                if (t.right != null)
                    stack.push(t.right);
                if (t.left != null)
                    stack.push(t.left);
            }
        }
    }

    // 非递归 中序遍历
    public static void inOrderUnRecur(Node head){
        System.out.print("in-order: ");
        if (head != null){
            Stack<Node> stack = new Stack<>();
            while (!stack.isEmpty() || head != null){
                if (head != null){
                    stack.push(head);
                    head = head.left;
                }else{
                    head = stack.pop();
                    System.out.print(head.value + " ");
                    head = head.right;
                }

            }

        }
    }

    // 非递归 后序遍历
    public static void posOrderUnRecur(Node head){
        System.out.print("pos-order: ");
        if (head != null){
            Stack<Node> s1 = new Stack<>();
            Stack<Node> s2 = new Stack<>();
            s1.push(head);
            while (!s1.isEmpty()){
                head = s1.pop();
                s2.push(head);
                if (head.left != null) s1.push(head.left);
                if (head.right != null) s1.push(head.right);
            }
            while (!s2.isEmpty()){
                System.out.print(s2.pop().value + " ");
            }
        }
    }

    public static void main(String[] args) {
        //          1
        //         /  \
        //        2    3
        //       /\    /\
        //      4  5   6 7

        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);
        preOrderUnRecur(head);
        System.out.println(" ");
        inOrderUnRecur(head);
        System.out.println(" ");
        posOrderUnRecur(head);
    }
}
class Node{
   public int value;
   public Node left;
   public Node right;

    public Node(int value) {
        this.value = value;
    }
}