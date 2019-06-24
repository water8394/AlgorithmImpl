package listNode;

public class RemoveElements {

    public ListNode removeElements(ListNode head, int val) {
        ListNode first = head;
        ListNode pre = first;
        while (head != null){
            if (head.val == val){
                if (pre == head){
                    first = first.next;
                    head = head.next;
                    pre = head;
                }else {
                    pre.next = head.next;
                    pre = head;
                    head = head.next;
                }
            }else {
                pre = head;
                head = head.next;
            }
        }
        return first;
    }
}
