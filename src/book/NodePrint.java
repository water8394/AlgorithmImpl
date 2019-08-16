package book;

import java.util.Stack;

public class NodePrint {

    // 非递归 先序遍历
    public static void preOrderUnRecur(ListNode head){
        System.out.print("pre-order: ");
        if (head != null){
            Stack<ListNode> stack = new Stack<>();
            stack.add(head);
            while (!stack.isEmpty()){
                ListNode t = stack.pop();
                System.out.print(t.value + " ");
                if (t.right != null)
                    stack.push(t.right);
                if (t.left != null)
                    stack.push(t.left);
            }
        }
    }

    // 非递归 中序遍历
    public static void inOrderUnRecur(ListNode head){
        System.out.print("in-order: ");
        if (head != null){
            Stack<ListNode> stack = new Stack<>();
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
    public static void posOrderUnRecur(ListNode head){
        System.out.print("pos-order: ");
        if (head != null){
            Stack<ListNode> s1 = new Stack<>();
            Stack<ListNode> s2 = new Stack<>();
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

        ListNode head = new ListNode(1);
        head.left = new ListNode(2);
        head.right = new ListNode(3);
        head.left.left = new ListNode(4);
        head.left.right = new ListNode(5);
        head.right.left = new ListNode(6);
        head.right.right = new ListNode(7);
        preOrderUnRecur(head);
        System.out.println(" ");
        inOrderUnRecur(head);
        System.out.println(" ");
        posOrderUnRecur(head);
    }
}
class ListNode {
   public int value;
   public ListNode left;
   public ListNode right;

    public ListNode(int value) {
        this.value = value;
    }
}