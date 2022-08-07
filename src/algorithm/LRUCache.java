package algorithm;

import java.util.HashMap;
import java.util.Map;

// 节点类
class Node {
    String key;
    Object val;
    Node pre;
    Node next;

    public Node(String key, Object val) {
        this.key = key;
        this.val = val;
    }
}

public class LRUCache {
    int capacity;
    Node head;
    Node tail;
    Map<String, Node> map = new HashMap<>();

    public LRUCache(int capacity) {
        if (capacity < 1) {
            throw new IllegalArgumentException("容量小于1");
        }
        this.capacity = capacity;
    }

    public void put(String key, Object val) {
        if (head == null) {     // 此时链表为null，插入的是头节点
            head = new Node(key, val);
            tail = head;
            map.put(key, head);
            return;
        }
        Node node = map.get(key);
        if (node != null) {
            node.val = val;
            removeAndInsert(node);
        } else {
            Node tmp = new Node(key, val);
            // 要先插入头部，否则满了先删除的话，如果容量为1，会丢失head和tail
            head.pre = tmp;
            tmp.next = head;
            tmp.pre = null;
            head = tmp;
            map.put(key, tmp);
            if (map.size() - 1 >= capacity) {
                map.remove(tail.key);
                tail.pre.next = null;
                tail = tail.pre;
            }
        }

    }

    public Object get(String key) {
        if (map.containsKey(key)) {     // 不能直接判断 value != null，因为映射的值可能就是null
            Node node = map.get(key);
            removeAndInsert(node);
            return node.val;
        }
        return null;
    }

    private void removeAndInsert(Node node) {
        // 删除的节点可能是头、尾或其他节点
        if (node == head) return;
        else if (node == tail) {        // 此时非头，链表至少有两个节点
            tail.pre.next = null;
            tail = tail.pre;
        } else {         // 此时非头尾，链表至少有三个节点，待删除的节点在中间
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
        // 插入头部
        head.pre = node;
        node.next = head;
        node.pre = null;
        head = node;
    }
}

class Test{
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put("1", 1);
        cache.put("2", 2);
        System.out.println(cache.get("1"));       // 返回 1
        cache.put("3", 3);    // 去除 key 2
        System.out.println(cache.get("2"));       // 返回 null (未找到key 2)
        System.out.println(cache.get("3"));       // 返回 3
        cache.put("4", 4);    // 去除 key 1
        System.out.println(cache.get("1"));       // 返回 null (未找到 key 1)
        System.out.println(cache.get("3"));       // 返回 3
        System.out.println(cache.get("4"));       // 返回 4
    }
}
