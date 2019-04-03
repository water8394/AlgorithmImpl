package listNode;

public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val){
        this.val = val;
    }

    @Override
    public String toString() {
        return val+"";
    }

    public static void trvalListNode(ListNode a){

        while (a != null){
            System.out.print(a + " ");
            a = a.next;
        }
        System.out.println(" ");
    }

    public boolean hasNext(){
        return next != null;
    }
}
