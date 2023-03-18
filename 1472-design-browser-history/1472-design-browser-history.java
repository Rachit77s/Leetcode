class BrowserHistory {

    public class Node{
        String url;
        Node next, prev;
        public Node(String url) {
            this.url = url;
            next = null;
            prev = null;
        }
    }
    
    Node head, curr;
    
    public BrowserHistory(String homepage) {
        
        curr = new Node(homepage);
        
    }
    
    public void visit(String url) {
        
        Node temp = new Node(url);
        curr.next = temp;
        temp.prev = curr;
        curr = curr.next;
    }
    
    public String back(int steps) {
        
        while(curr.prev != null && steps-- > 0)
        {
            curr = curr.prev;
        }
        
        return curr.url;
    }
    
    public String forward(int steps) {
        
        while(curr.next != null && steps-- > 0)
        {
            curr = curr.next;
        }
        
        return curr.url;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */