package listNode;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode rst = new ListNode(0);
        ListNode v = rst;
        int offset = 0;
        while (l1!=null && l2!=null){

            int a = l1.val;
            int b = l2.val;
            int sum = a + b + offset;
            if (sum > 9){
                sum -= 10;
                offset = 1;
            }else{
                offset = 0;
            }
            l1 = l1.next;
            l2 = l2.next;
            rst.next = new ListNode(sum);
            rst = rst.next;
        }
        while (l1!=null){
            int val = l1.val;
            l1 = l1.next;
            if (offset == 1){
                val += 1;
                offset = 0;
            }
            if (val > 9){
                val -= 10;
                offset = 1;
            }
            rst.next = new ListNode(val);
            rst = rst.next;
        }
        while (l2!=null){
            int val = l2.val;
            l2 = l2.next;
            if (offset == 1){
                val += 1;
                offset = 0;
            }
            if (val > 9){
                val -= 10;
                offset = 1;
            }
            rst.next = new ListNode(val);
            rst = rst.next;
        }
        if (offset == 1){
            rst.next = new ListNode(1);
        }
        return v.next;

    }



    public static void main(String[] args) {
        AddTwoNumbers sol = new AddTwoNumbers();

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        ListNode listNode = sol.addTwoNumbers(l1, l2);
        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

}
