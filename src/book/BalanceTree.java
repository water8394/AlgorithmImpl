package book;

public class BalanceTree {

    private static class Node{
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }
    private boolean flag = true;

    public int process(Node head){
        if (head == null) return 0;
        int lHeight = process(head.left);
        int rHeight = process(head.right);
        if (Math.abs(lHeight-rHeight) > 1) flag = false;
        return Math.max(lHeight, rHeight) + 1;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);

        BalanceTree b = new BalanceTree();
        int process = b.process(head);
        System.out.println(process);
        System.out.println(b.flag);
    }

}
