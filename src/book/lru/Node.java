package book.lru;

public class Node<V> {
    public V value;
    public Node last;
    public Node next;

    public Node(V value) {
        this.value = value;
    }
}
