package book.lru;

import java.util.HashMap;

public class MyCache<K, V> {
    private HashMap<K, Node<V>> keyNodeMap;
    private HashMap<Node<V>, K> nodeKeyMap;
    private DoubleNodeLinkedList<V> nodeList;
    private int capcity;

    public MyCache(int capcity) {
        this.keyNodeMap = new HashMap<>();
        this.nodeKeyMap = new HashMap<>();
        this.nodeList = new DoubleNodeLinkedList<V>();
        this.capcity = capcity;
    }

    public V get(K key){
        if (this.keyNodeMap.containsKey(key)){
            Node<V> node = this.keyNodeMap.get(key);
            this.nodeList.moveNodeToTail(node);
            return node.value;
        }
        return null;
    }

    public void set(K key, V value){
        if (this.keyNodeMap.containsKey(key)){
            Node<V> node = this.keyNodeMap.get(key);
            node.value = value;
            this.nodeList.moveNodeToTail(node);
        }else {
            Node<V> node = new Node<>(value);
            this.keyNodeMap.put(key, node);
            this.nodeKeyMap.put(node, key);
            this.nodeList.addNode(node);
            if(this.keyNodeMap.size() == this.capcity+1){
                this.removeMostUnuserdCache();
            }
        }
    }

    private void removeMostUnuserdCache(){
        Node<V> removeNode = this.nodeList.removeHead();
        K remove = this.nodeKeyMap.remove(removeNode);
        this.keyNodeMap.remove(remove);
    }

}
