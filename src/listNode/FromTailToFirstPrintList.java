package listNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class FromTailToFirstPrintList {

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> al = new ArrayList<>();
        while (listNode != null) {
            stack.add(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> ret = new ArrayList<Integer>();
        while (!stack.isEmpty())
            ret.add(stack.pop());
        return ret;
    }

    public static void main(String[] args) {

        ListNode testNode = new ListNode(1);
        testNode.next = new ListNode(2);
        testNode.next.next = new ListNode(3);

        FromTailToFirstPrintList sol = new FromTailToFirstPrintList();

        ArrayList answer = sol.printListFromTailToHead(testNode);

        answer.forEach(System.out::println);

    }
}
