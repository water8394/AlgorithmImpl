package listNode;

public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        if(head==null || head.next==null)return null;
        ListNode p=head;
        ListNode q=head;
        while(q.next!=null && q.next.next!=null){
            p=p.next;
            q=q.next.next;
            if(p==q){//如果相交
                p=head;
                while(p!=q){
                    p=p.next;
                    q=q.next;
                }
                return p;
            }
        }
        return null;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode cycle = new ListNode(2);
        head.next = cycle;
        cycle.next = new ListNode(0);
        cycle.next.next = new ListNode(4);
        cycle.next.next.next = cycle;
        DetectCycle sol = new DetectCycle();
        ListNode listNode = sol.detectCycle(head);
        System.out.println("-");
    }
}
