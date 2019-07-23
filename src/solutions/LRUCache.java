package solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * 146. Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following
 * operations: get and put.
 * <p>
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity,
 * it should invalidate the least recently used item before inserting a new item.
 * <p>
 * The cache is initialized with a positive capacity.
 * <p>
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 * <p>
 * Example:
 * <p>
 * LRUCache cache = new LRUCache(2);
 * <p>
 * cache.put(1,1);
 * cache.put(2,2);
 * cache.get(1);      // returns 1
 * cache.put(3,3);    // evicts key 2
 * cache.get(2);      // returns -1 (not found)
 * cache.put(4,4);    // evicts key 1
 * cache.get(1);      // returns -1 (not found)
 * cache.get(3);      // returns 3
 * cache.get(4);      // returns 4
 */

public class LRUCache
{
    // The basic idea is to have a doubly-linked list represent the LRU cache. The front of the list is the most
    // recently used node, such as when a new node is added or a new get() call occurs on the node. The back of the
    // list is the most LRU node and will be the node that gets evicted when the list reaches capacity. Furthermore,
    // a hash map is used to store they key-value pairs of key-nodes to quickly fetch the desired node in O(1) time.
    public class DLLNode
    {
        private int key;
        private int value;
        private DLLNode prev;
        private DLLNode next;
    }

    private DLLNode head;
    private DLLNode tail;
    private int capacity;
    private int size;
    private Map<Integer, DLLNode> map;

    public LRUCache(int capacity)
    {
        this.head = new DLLNode();
        this.tail = new DLLNode();
        this.head.next = this.tail;
        this.head.prev = null;
        this.tail.prev = this.head;
        this.tail.next = null;

        this.map = new HashMap<>();
        this.capacity = capacity;
        this.size = 0;
    }

    public int get(int key)
    {
        if (this.map.get(key) != null)
        {
            // If the node exists, we must also update it to be the most recently used node at the front
            DLLNode node = this.map.get(key);
            // Remove the node from the current position
            this.removeNode(node);
            // Add the node to the front
            this.addToFront(node);
            return node.value;
        }

        return -1;
    }

    public void put(int key, int value)
    {
        if (this.map.get(key) == null)
        {
            DLLNode node = new DLLNode();
            node.key = key;
            node.value = value;
            this.size++;

            // If the size has reached the capacity, we must evict the LRU node, and add the new node to the front
            if (this.size > this.capacity)
            {
                this.evict();
                this.addToFront(node);
                this.map.put(key, node);
            }
            else
            {
                // Otherwise, we just add the node to the front
                this.addToFront(node);
                this.map.put(key, node);
            }
        }
        else
        {
            // If the node already exists, just update the value, and move it to the front
            DLLNode node = this.map.get(key);
            node.value = value;
            this.removeNode(node);
            this.addToFront(node);
        }
    }

    private void removeNode(DLLNode node)
    {
        // Removes the node from its current position
        DLLNode next = node.next;
        DLLNode prev = node.prev;
        prev.next = next;
        next.prev = prev;
    }

    private void addToFront(DLLNode node)
    {
        // Adds the node to the front of the list
        DLLNode temp = this.head.next;
        this.head.next = node;
        node.prev = this.head;
        node.next = temp;
        temp.prev = node;
    }

    private void evict()
    {
        // Remove the LRU node and remove it from the map
        DLLNode lruNode = this.tail.prev;
        this.removeNode(lruNode);
        this.map.remove(lruNode.key);
        this.size--;
    }

    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */
    public static void main(String[] args)
    {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);                        // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);                        // evicts key 1
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4
    }
}
