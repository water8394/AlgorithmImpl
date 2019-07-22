package listNode;

public class HasCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next !=null){
            if (fast.val == slow.val) return true;

            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }

}
