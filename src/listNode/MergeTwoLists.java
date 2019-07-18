package listNode;

public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode first;
        if (cur1.val > cur2.val){
            first = cur1;
            cur1 = cur1.next;
        }else {
            first = cur2;
            cur2 = cur2.next;
        }

        ListNode cur = first;
        ListNode head = cur;
        while (cur1 != null && cur2 != null){
            if (cur1.val > cur2.val){
                cur.next = cur1;
                cur1 = cur1.next;
            }else{
                cur.next = cur2;
                cur2 = cur2.next;
            }
            cur = cur.next;
        }

        while (cur1 != null){
            cur.next = cur1.next;
            cur1 = cur1.next;
            cur = cur.next;
        }
        while (cur2 != null){
            cur.next = cur2.next;
            cur2 = cur2.next;
            cur = cur.next;
        }
        return head;
    }


    public static void main(String[] args) {
        ListNode l1 =  new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(5);
        ListNode l2 =  new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        MergeTwoLists sol = new MergeTwoLists();
        sol.mergeTwoLists(l1,l2);

    }
}
