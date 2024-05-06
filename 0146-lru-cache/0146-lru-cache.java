class LRUCache {
    
    // Step 1 : Create Doubly LinkedList class
    class DoublyLLNode
    {
        public int key;
        public int value;

        // Reference Pointers
        public DoublyLLNode prev;
        public DoublyLLNode next;

        public DoublyLLNode(int key, int value)
        {
            this.key = key;
            this.value = value;
        }
    }
    
    // Step 2: Create the LRUCache with 2 dummy nodes(head and tail), and a HashMap
    // 2 Doubly LL, Head and Tail Dummy Nodes/Pointers
    DoublyLLNode head = new DoublyLLNode(0, 0);
    DoublyLLNode tail = new DoublyLLNode(0, 0);
    
    // Key, Address of DLL Node
    HashMap<Integer, DoublyLLNode> map = new HashMap<Integer, DoublyLLNode>();
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        
        // Attach head and tail
        head.next = tail;
        tail.prev = head;
    }
    
    // Step 3: GET method
    // Get Method: Find node, if found -> delete node and then insert node.
    // Find the node address in the HashMap, if found, then remove it from its current position and add it to the head of the Doubly LL
    // If Map has the key, then get the node address via the key, and this node becomes the recently used node,
    // so remove it from its prev position and insert it just after the head.
    public int get(int key) {
        
        if(map.containsKey(key))
        {
            // Get the Node's reference pointer
            DoublyLLNode node = map.get(key);

            // Now, this key becomes the LRU, therefore, perform 2 steps:
            // a) Remove the node from its current position
            // b) Insert the node at the head of the Doubly LL
            remove(node);
            insertJustAfterHead(node); // This is moveToHead function
            return node.value;  
        }
        
        return -1;
    }
    
    // Step 4: remove Method, Remove the given Node, and link its prev and next node in O(1)
    public void remove(DoublyLLNode node) {
        
        // IMP: First Remove the node from Map
        map.remove(node.key);
        
        // Unlink the Node from other Nodes i.e. from its prev and next node
        node.prev.next = node.next;
        node.next.prev = node.prev;

        /*
        // Clean way to remove the node from the Doubly LL
        // Get the prev and next nodes of the node to be removed
        DoublyLLNode prevNode = node.prev;
        DoublyLLNode nextNode = node.next;

        // Now, remove the node from its current position
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        */
    }
    
    // Step 5: Create a function to add a node to the head of the Doubly LL
    // InsertNode Method, just after the dummy Head node in O(1) time
    // Move node to the head i.e. moveToHead()
    public void insertJustAfterHead(DoublyLLNode nodeToInsert) {
        
        // IMP: First, Directly store the node in the map
        map.put(nodeToInsert.key, nodeToInsert);

        // Insert the node just after the dummy head node
        DoublyLLNode tempNode = head.next;
        head.next = nodeToInsert;
        nodeToInsert.prev = head;
        
        tempNode.prev = nodeToInsert;
        nodeToInsert.next = tempNode;
    }
    
    // Step 6: PUT Method
    // Put Method: If the key is already present, then update the value and move the node to the head of the Doubly LL
    // If the map contains node, remove the node since the same node with a new value came.
    // If capacity becomes overflow, remove the node just before the tail node i.e. LRU node.
    public void put(int key, int value) {
        
        // IMP:  1st check does the LRUCache contains this key or not
        if(map.containsKey(key))
        {
            // Get the Node's reference pointer
            DoublyLLNode node = map.get(key);

            // Remove the node because the same node with updated value has come up, we need to insert its new value.
            remove(node);
        }

        // If the size of LRUCache got full or reached its capacity, remove the node which is just prev to the tail.
        if(map.size() == capacity)
            remove(tail.prev);

        // At the last, insert the node to the head of the Doubly LL
        insertJustAfterHead(new DoublyLLNode(key, value));
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
