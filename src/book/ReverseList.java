package book;

public class ReverseList {

    // 内部节点类
    static class Node{
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    // 反转链表
    public static Node reverseList(Node head){
        Node pre = null;
        Node next = null;
        while (head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    // 反转部分链表
    public static Node reversePart(Node head, int from, int to){
        int  len = 0;
        Node node1 = head;
        Node fPre = null;
        Node tPos = null;
        while (node1 != null){
            fPre = len == from-1 ? node1 : fPre;
            tPos = len == to+1 ? node1 : tPos;
            len++;
            node1 = node1.next;
        }
        if (from > to || from < 1 || to > len){
            return head;
        }

        node1 = fPre == null ? head : fPre.next;
        Node node2 = node1.next;
        node1.next = tPos;
        Node next = null;
        while (node2 != tPos){
            next = node2.next;
            node2.next = node1;
            node1 = node2;
            node2 = next;
        }
        if (fPre != null){
            fPre.next = node1;
            return head;
        }
        return node1;
    }

    // 打印链表
    public static void tranver(Node head, String explain){
        System.out.print(explain + ": ");
        while (head != null){
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println(" ");
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        // 反转链表
        tranver(head, "原始链表");
        head = reverseList(head);
        tranver(head, "反转后链表");
        // 反转 1-3
        head = reverseList(head);
        head = reversePart(head, 2, 3);
        tranver(head, "反转2->3");
    }
}
