package listNode;

public class ReverseList {

    public ListNode reverseList(ListNode head) {

        ListNode next = head;
        ListNode pre = null;

        while (next != null){
            ListNode tmp = next.next;
            next.next = pre;
            pre = next;
            next = tmp;
        }
        return next;
    }

}
