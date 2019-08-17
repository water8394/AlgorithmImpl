package book.lru;

import java.util.HashMap;

public class LRUCache<K, V> {
    private int currentCacheSize;
    private int cacheCapticy;
    private HashMap<K, CacheNode> caches;
    private CacheNode first;
    private CacheNode last;

    public LRUCache(int size) {
        this.currentCacheSize = 0;
        this.cacheCapticy = size;
        caches = new HashMap<>(size);
    }

    // 放入元素
    public void put(K k , V v){
        CacheNode node = caches.get(k);
        if (node == null){
            if (caches.size() >= cacheCapticy){
                caches.remove(last.key);
                removeLast();
            }
            node = new CacheNode();
            node.key = k;
        }
        node.value = v;
        moveToFirst(node);
        caches.put(k, node);
    }

    // 获取元素
    public Object get(K k){
        CacheNode node = caches.get(k);
        if (node == null){
            return null;
        }
        moveToFirst(node);
        return node.value;
    }

    // 删除元素 根据k
    public Object remove(K k){
        CacheNode node = caches.get(k);
        if (node != null){
            if (node.pre != null){
                node.pre.next = node.next;
            }
            if (node.next != null){
                node.next.pre = node.pre;
            }
            if (node == first){
                first = node.next;
            }
            if (node == last){
                last = node.pre;
            }
        }
        return caches.remove(k);
    }

    // 移动到队首
    private void moveToFirst(CacheNode node){
        if (first == node) return;
        if(node.next != null){
            node.next.pre = node.pre;
        }
        if (node.pre != null){
            node.pre.next = node.next;
        }
        if (node == last){
            last = last.pre;
        }
        if (first == null || last == null){
            first = last = node;
            return;
        }

        node.next = first;
        first.pre = node;
        first = node;
        first.pre = null;
    }

    // 删除队尾元素
    private void removeLast(){
        if (last != null){
            last = last.pre;
            if (last == null){
                first = null;
            }else {
                last.next = null;
            }
        }
    }



    class CacheNode{
        CacheNode pre;
        CacheNode next;
        Object key;
        Object value;
        public CacheNode() {
        }
    }
}
