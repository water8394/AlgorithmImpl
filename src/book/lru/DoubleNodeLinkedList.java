package book.lru;

public class DoubleNodeLinkedList<V> {

    private Node<V> head;
    private Node<V> tail;

    public DoubleNodeLinkedList() {
        this.head = null;
        this.tail = null;
    }

    // 添加节点
    public void addNode(Node<V> node){
        if (this.head == null){
            this.head = node;
            this.tail = node;
        }else{
            this.tail.next = node;
            node.last = this.tail;
            this.tail = node;
        }
    }

    // 将节点移动到最后
    public void moveNodeToTail(Node<V> node){
        if (this.tail == node) return;
        if (this.head == node){
            this.head = node.next;
            this.head.last = node.last;
        }else {
            node.last.next = node.next;
            node.next.last = node.last;
        }
        node.last = this.tail;
        node.next = null;
        this.tail.next = node;
        this.tail = node;
    }

    // 删除头节点
    public Node<V> removeHead(){
        if (this.head == null) {
            return null;
        }
        Node<V> res = this.head;
        if (this.head == this.tail){
            this.head = null;
            this.tail = null;
        }else{
            this.head = res.next;
            res.next = null;
            this.head.last = null;
        }
        return res;
    }

}
