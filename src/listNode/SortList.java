package listNode;

public class SortList {
    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) return head;
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast !=null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;

        ListNode left= sortList(head);
        ListNode right = sortList(tmp);

        ListNode fake = new ListNode(0);
        ListNode res = fake;
        while (left != null || right != null){
            if (left.val < right.val){
                fake.next = left;
                left = left.next;
            }else{
                fake.next = right;
                right = right.next;
            }
            fake = fake.next;
        }
        fake.next = left !=null ? left : right;

        return res.next;
    }
}
