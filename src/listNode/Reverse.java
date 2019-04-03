package listNode;

import java.util.List;

public class Reverse {

    public ListNode ReverseList(ListNode head) {

        ListNode cur = head;
        ListNode prev = null;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;

    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        a.next = new ListNode(2);
        a.next.next = new ListNode(3);
        a.next.next.next = new ListNode(4);

        ListNode.trvalListNode(a);

        Reverse sol = new Reverse();
        ListNode val = sol.ReverseList(a);

        ListNode.trvalListNode(val);

    }
}
