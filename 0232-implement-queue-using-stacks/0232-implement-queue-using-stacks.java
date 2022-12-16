class MyQueue {

    Stack<Integer> stk1;
    Stack<Integer> stk2;
    
    public MyQueue() {
        
        stk1 = new Stack<Integer>();
        stk2 = new Stack<Integer>();
        
    }
    
    public void push(int x) {
        stk1.push(x);
    }
    
    public int pop() {
        
        while(!stk1.isEmpty())
        {
            stk2.push(stk1.pop());
        }
        
        int ele = stk2.pop();
        
        while(!stk2.isEmpty())
        {
            stk1.push(stk2.pop());
        }
        
        return ele;
    }
    
    public int peek() {
        
        while(!stk1.isEmpty())
        {
            stk2.push(stk1.pop());
        }
        
        int ele = stk2.peek();
        
        while(!stk2.isEmpty())
        {
            stk1.push(stk2.pop());
        }
        
        return ele;
        
    }
    
    public boolean empty() {
        
        return stk1.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */