package book;

public class PrintCommonPart {
    public static class Node{
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public void printCommonPart(Node head1, Node head2){
        System.out.print("Common Part: ");
        while (head1 != null && head2 != null){
            if (head1.value < head2.value){
                head1 = head1.next;
            }else if (head1.value > head2.value){
                head2 = head2.next;
            }else{
                System.out.print(head1.value + " ");
                head1 = head1.next;
                head2 = head2.next;
            }
        }
        System.out.println(" ");
    }

    public static void main(String[] args) {
        Node h1 = new Node(1);
        h1.next = new Node(2);
        h1.next.next = new Node(3);
        h1.next.next.next = new Node(4);
        Node h2 = new Node(3);
        h2.next = new Node(4);
        h2.next.next = new Node(5);
        h2.next.next.next = new Node(6);


        PrintCommonPart sol = new PrintCommonPart();
        sol.printCommonPart(h1, h2);
    }

}
