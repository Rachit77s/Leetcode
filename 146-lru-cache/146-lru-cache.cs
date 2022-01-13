public class LRUCache {

    // Step 2: Setup the LRUCache with dummy nodes, and Map
    
    // 2 Doubly LL, Head and Tail Dummy Nodes/Pointers
    DoublyLLNode head = new DoublyLLNode(0, 0);
    DoublyLLNode tail = new DoublyLLNode(0, 0);
    
    Dictionary<int, DoublyLLNode> map = new Dictionary<int, DoublyLLNode>(); 
    int capacity;
    
    public LRUCache(int capacity) 
    {
        this.capacity = capacity;
        
        // Attach head and tail
        head.next = tail;
        tail.prev = head;
    }
    
    // Step 3: Get Method 
    // If Map has the key, then get the node based on the key, and this node becomes the recently used node, so remove it from its prev position and insert it just after the head.
    // T.C : O(1)
    public int Get(int key) 
    {
        if(map.ContainsKey(key))
        {
            // Get the Node's reference pointer
            DoublyLLNode node = map[key];
            
            // Now, this key becomes the LRU, therefore, perform 2 steps
            // a. remove it
            // b. insert it into new place just after the head
            DeleteNode(node);
            InsertNode(node);
            
            return node.value;
        }
        
        return -1;
    }
    
    // Step 4: DeleteNode Method, Remove the given Node, and link its prev and next node
    // T.C : O(1)
    public void DeleteNode(DoublyLLNode node)
    {
        // IMP: First Remove the node from Map
        map.Remove(node.key);
        
        // Unlink the Node from other Nodes i.e. from its prev and next node
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    // Step 5: InsertNode Method, just after the dummy Head node
    // T.C : O(1)
    public void InsertNode(DoublyLLNode node)
    {
        // IMP: First, Directly store the node in the map 
        map.Add(node.key, node);
        
        // Now, insert this current node just after the dummy Head node
        DoublyLLNode tempNode = head.next;
        head.next = node;
        node.prev = head;
        tempNode.prev = node;
        node.next = tempNode;
    }
    
    // Step 6: Put Method
    // If the map contains node, remove the node since the same node with a new value came. If capacity becomes overflow, remove the node just before the tail node i.e. LRU node.
    // T.C : O(1)
    public void Put(int key, int value) 
    {
        // IMP:  1st check does the LRUCache contains this key or not
        if(map.ContainsKey(key))
        {
            // Get the Node's reference pointer
            DoublyLLNode node = map[key];
            
            // If it contains the key, we need to remove it,
            // Because the same key with a new value has come up, we need to insert its new value.
            DeleteNode(node);
            
        }
        
        // If the size of LRUCache got full or reached its capacity, remove the LRU DLL node which is just prev to the DLL.
        if(map.Count == capacity)
        {
            DeleteNode(tail.prev);
        }
        
        // At the last, insert the new Node just after the DLL Head
        InsertNode(new DoublyLLNode(key, value));
    }
    
    // Step 1 : Create Doubly LinkedList class
    public class DoublyLLNode
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
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.Get(key);
 * obj.Put(key,value);
 */