class Solution {
    public int evalRPN(String[] tokens) {
        
        return Solve(tokens);
    }
    
    public int Solve(String[] A)
    {
        Stack<Integer> stk = new Stack();
        
        for(String item : A)
        {
            if(item.equals("+"))
            {
                // System.out.print(item);
                int x = stk.pop();
                int y = stk.pop();
                stk.push(x + y);
            }
            else if(item.equals("-"))
            {
                int x = stk.pop();
                int y = stk.pop();
                stk.push(y - x);
            }
            else if(item.equals("*"))
            {
                int x = stk.pop();
                int y = stk.pop();
                stk.push(x * y);
            }
            else if(item.equals("/"))
            {
                int x = stk.pop();
                int y = stk.pop();
                stk.push(y / x);
            }
            else
            {
                // System.out.print(item);
                stk.add(Integer.parseInt(item)); 
            }
                
        }
        
        return stk.peek();
    }
}