
package nowcode.moveList;

import java.util.Scanner;

public class Main {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /*请完成下面这个函数，实现题目要求的功能
     ******************************开始写代码******************************/
    static ListNode partition(ListNode head, int m) {
        ListNode tmp = new ListNode(0);
        ListNode ans = tmp;
        ListNode pre = null;
        ListNode first = head;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val <= m) {
                ListNode next = cur.next;
                if (pre == null) {
                    first = next;
                    tmp.next = cur;
                    tmp = tmp.next;
                    cur.next = null;
                    cur = next;
                } else {
                    pre.next = next;
                    tmp.next = cur;
                    tmp = tmp.next;
                    cur.next = null;
                    cur = next;
                }
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        tmp.next = first;
        return ans.next;
    }

    /******************************结束写代码******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ListNode head = null;
        ListNode node = null;
        int m = in.nextInt();
        while (in.hasNextInt()) {
            int v = in.nextInt();
            if (head == null) {
                node = new ListNode(v);
                head = node;
            } else {
                node.next = new ListNode(v);
                node = node.next;
            }
        }
        head = partition(head, m);
        if (head != null) {
            System.out.print(head.val);
            head = head.next;
            while (head != null) {
                System.out.print(",");
                System.out.print(head.val);
                head = head.next;
            }
        }
        System.out.println();
    }
}