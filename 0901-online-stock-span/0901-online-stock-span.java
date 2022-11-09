class StockSpanner {

    Stack<Pair<Integer, Integer>> stk;
    
    public StockSpanner() {
        
        stk = new Stack<>();
    }
    
    public int next(int price) {
        
        int span = 1;
        
        // If the current price is greater than stack peek.
        while(!stk.isEmpty() && price >= stk.peek().getKey())
        {
            Pair<Integer, Integer> currPair = stk.pop();
            span = span + currPair.getValue(); // getValue gives us 2nd value
        }
        
        stk.push(new Pair<Integer, Integer>(price, span));
        
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */

// 0   1  2  3  4  5  6
// 100,80,60,70,60,75,85  
// 1    1  1  2 1   4  
    
    
// i > stackTop        temperatures[i] > temperatures[stk.Peek()]
// ans.add

// stk add


//           4
// 100 80 60 60    