class LRUCache {
    class Node {
        int key;
        int value;
        Node next;
        Node prev;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = this.prev = null;
        }
    }

    Node head;
    Node tail;

    HashMap<Integer, Node> map;
    int cap;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);

        head.next = tail;
        tail.prev = head;

        cap = capacity;
    }

    private void removeNode(Node n) {
        Node nm1 = n.prev;
        Node np1 = n.next;

        nm1.next = np1;
        np1.prev = nm1;
    }

    private void addBeforeTail(Node nn) {
        // find tail-1 th node
        Node tm1 = tail.prev;
        nn.next = tail;
        tail.prev = nn;
        tm1.next = nn;
        nn.prev = tm1;
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
            // if key available 
            // 1. Get the Node 
            Node n = map.get(key);
            // 2. Make it most recent used 
            removeNode(n);
            addBeforeTail(n);
            // 3. Return the value 
            return n.value;
        } else {
            // if key is not available 
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            // if key is present 
            // 1. get the node 
            Node n = map.get(key);
            // 2. update the value 
            n.value = value;
            // 3. Make it most recent used 
            removeNode(n);
            addBeforeTail(n);
        } else {
            // if key is not present 
            // 1. Create a new Node 
            Node nn = new Node(key, value);
            // 2. Add it before Tail
            addBeforeTail(nn);
            // 3. Add it in map 
            map.put(key, nn);
            // 4. Check the capacity 
            if(map.size() > cap) {
                // find and remove least recent used 
                Node lru = head.next;
                removeNode(lru);
                map.remove(lru.key);
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */