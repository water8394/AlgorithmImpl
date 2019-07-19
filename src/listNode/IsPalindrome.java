package listNode;

public class IsPalindrome {
    public boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        ListNode pre = null;
        ListNode fake = null;

        while (fast != null && fast.next != null){
            fake = slow;
            slow = slow.next;
            fast = fast.next.next;
            fake.next = pre;
            pre = fake;
        }

        ListNode p2 = slow.next;
        slow.next = pre;

        ListNode p1 = fast == null ? slow.next : slow;


        while (p1 != null){
            if (p1.val != p2.val) return false;
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
//        head.next.next = new ListNode(2);
//        head.next.next.next = new ListNode(2);
//        head.next.next.next.next = new ListNode(1);

        IsPalindrome sol = new IsPalindrome();
        boolean palindrome = sol.isPalindrome(head);
        System.out.println(palindrome);
    }

}
