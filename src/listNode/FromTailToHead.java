package listNode;

import java.util.ArrayList;
import java.util.Stack;

public class FromTailToHead {

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> list = new ArrayList<>();
        while (!stack.empty()) list.add(stack.pop());
        return list;
    }
}
