package listNode;

public class ReverseBetween {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode first = head;
        ListNode fakeHead = null;
        if (m == n) return first;
        if (m == 1){
            fakeHead = new ListNode(0);
            fakeHead.next = head;
            head = fakeHead;
            n++;
        }
        ListNode start;
        ListNode end;
        int i;
        for (i = 1; i < m-1; i++) {
            head = head.next;
        }
        start = head;
        head = head.next;


        ListNode pre = null;
        ListNode cur = head;
        end = head;
        while (cur != null && i++ <= n){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        end.next = cur;
        start.next = pre;
        if (fakeHead != null) return fakeHead.next;
        return first;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(5);

        ReverseBetween sol = new ReverseBetween();
        sol.reverseBetween(head, 1 , 2);
    }

}
