class MyQueue {

    /*
        Algo:--
        
        Push: Push element into stack1 : O(1)
        Pop(O(N)) operation: 
            Transfer all the elements from stack1 to stack2
            Delete the top element from stack2
            Move back all the elements from stack2 to stack1
    */
    
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
        
        // Approach 1:
        // while(!stk1.isEmpty())
        // {
        //     stk2.push(stk1.pop());
        // }
        
        // Approach2
        if(stk2.isEmpty())
        {
            while(!stk1.isEmpty())
            {
                stk2.push(stk1.pop());
            }
        }

        
        int ele = stk2.pop();
        
//         while(!stk2.isEmpty())
//         {
//             stk1.push(stk2.pop());
//         }
        
        return ele;
    }
    
    public int peek() {
        
        // Approach1
        // while(!stk1.isEmpty())
        // {
        //     stk2.push(stk1.pop());
        // }
        
        // Approach2
        if(stk2.isEmpty())
        {
            while(!stk1.isEmpty())
            {
                stk2.push(stk1.pop());
            }
        }
        
        int ele = stk2.peek();
        
        // while(!stk2.isEmpty())
        // {
        //     stk1.push(stk2.pop());
        // }
        
        return ele;
        
    }
    
    public boolean empty() {
        
        if(stk1.isEmpty() && stk2.isEmpty())
            return true;
        
        return false;
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