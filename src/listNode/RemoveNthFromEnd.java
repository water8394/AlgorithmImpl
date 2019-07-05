package listNode;

import java.util.HashMap;
import java.util.Map;

public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        Map<Integer, ListNode> map = new HashMap<>();
        ListNode first = head;
        int cur = 0;
        while (first!= null) {
            map.put(cur++, first);
            first = first.next;
        }
        int change = cur - n;
        if (change == 0) {
            return head.next;
        } else if (change == cur) {
            map.get(change - 1).next = null;
        } else {
            map.get(change - 1).next = map.get(change + 1);
        }
        return head;
    }

}
